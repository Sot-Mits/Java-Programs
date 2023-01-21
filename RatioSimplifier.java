/* Note: I changed some stuff for clarity's sake but I didn't test the program again
   The logic and control flow *should* in theory be the same however so there shouldn't be anything wrong
   If there is though you know why. */
import java.util.Scanner;

public class RatioSimplifier {
	public static void main(String[] args) {
		System.out.println("This program simplifies a ratio into its lowest form.");
		System.out.println("How many parts in the ratio?");

		//Makes user input how many parts will be in the ratio
		int arrayElements = IntHandler();
		while (arrayElements < 1) {
			System.out.println("Very funny. Try again.");
			arrayElements = IntHandler();
		}
		//Puts the amount of the part in the ratio
		int[] ratio = new int[arrayElements];

		//Makes user input a value for all array entries
		for (int i = 0; i < arrayElements; i++) {
			System.out.println("Please enter value " + (i + 1));
			ratio[i] = IntHandler();
		}

		//Only use this for the end
		final int[] originalValues = ratio.clone(); 
		//Since it's not needed anymore
		keyboardInput.close(); 

		boolean canBeDivided = true;
		/* Checks if the greatest number can give an integer
		   A.k.a if all the numbers are equal */
		for (int i = 1; (i < arrayElements) && canBeDivided; i++) {
			if (ratio[i - 1] != ratio[i]) { 
				canBeDivided = false;
			}
		}

		//Gets the greatest number in array
		int greatestCommonDivisor = ratio[0];
		for (int i = 1; i < arrayElements; i++) {
			if (ratio[i] > greatestCommonDivisor) {
				greatestCommonDivisor = ratio[i];
			}
		}

		if (canBeDivided) {
			if (ratio[0] != 0) {
				for (int i = 0; i < arrayElements; i++) {
					//If the dividend and the divisor are equal the quotient is 1
					ratio[i] = 1; 
				}
			}
		}

		else {
			//At this point idk how to explain these without being tautologic
			//Since the ratio hasn't been divided this ensure it gets divided in the while loop
			canBeDivided = true; 
			//No divisor between x and x/2 (exclusive) can give an integer so it cuts straight to x/2
			greatestCommonDivisor /= 2; 

			//Does the same thing above but in a loop and for all numbers <= x/2
			//Should in theory cut down on time/resources
			while (canBeDivided) {
				//For loop checking that all quotients don't have a decimal
				for (int i = 0; (i < arrayElements) && canBeDivided; i++) {
					if ((ratio[i] % greatestCommonDivisor) != 0) {
						canBeDivided = false;
					}
				} 

				//Divides all the numbers if they don't leave a decimal
				if (canBeDivided) {
					for (int i = 0; i < arrayElements; i++) {
						ratio[i] /= greatestCommonDivisor;
					}
					break; 
				}
				//Gets loop ready for next iteration if it hasn't found the GCD.
				else {
					canBeDivided = true;
					greatestCommonDivisor--;
				}
			} 
		}

		//Prints out the two ratios
		RatioPrinter("Original ratio is ", originalValues);
		RatioPrinter("Simplified ratio is ", ratio);
	}

	static final Scanner keyboardInput = new Scanner(System.in);
	static String tempStringInput;
	public static int IntHandler() {
		tempStringInput = keyboardInput.nextLine();
		try {
			int intInput = Integer.parseInt(tempStringInput);
			return intInput;
		}
		catch (Exception exception) {
			System.out.println("Please enter a valid integer.");
			return IntHandler();
		}
	}

	public static void RatioPrinter(String message, int[] ratioArray) {
		System.out.print(message);
		for (int i = 0; i < (ratioArray.length - 1); i++) {
			System.out.print(ratioArray[i] + ":");
		}
		System.out.println(ratioArray[ratioArray.length - 1]);
	}
}
