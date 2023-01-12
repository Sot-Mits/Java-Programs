import java.util.Scanner;
import java.util.ArrayList;

public class AntiPrimer {
	
	public static void main(String[] args) {
		System.out.println("This program finds the highly composite numbers within a specified range.");
		System.out.println("Please enter the upper bound.");

		final int lowerBound = 1;
		int upperBound = IntHandler();
		keyboardInput.close();

		ArrayList<Integer> numberOfDivisors = new ArrayList<Integer>();
		numberOfDivisors.add(0);
		ArrayList<Integer> highlyCompositeNumber = new ArrayList<Integer>();
		highlyCompositeNumber.add(1);

		//int currentNumberOfDivisors;

		//This is here because the code doesn't work as it should when upperBound = 1
		if (upperBound < 1) {
			System.out.println("Please enter an integer greater than zero.");
			System.exit(0);
		}
		else if (upperBound != 1) {
			numberOfDivisors.add(1);
			highlyCompositeNumber.add(2);
			//Dividend
			for (int i = lowerBound; i <= upperBound; i++) {
				int currentNumberOfDivisors = 0;
				//Divisor
				//Divides until half the dividend
				for (int j = lowerBound; j <= (i / 2); j++) {
					if (i % j == 0) {
						currentNumberOfDivisors++;
					}
					
					//Current divisor against previous divisor
					if (currentNumberOfDivisors > (numberOfDivisors.get(numberOfDivisors.size() - 1))) {
						/* If the HCN's are equal then they're the same number
						   Updates the number of divisors */
						if (i == highlyCompositeNumber.get(numberOfDivisors.size() - 1)) {
							numberOfDivisors.set(numberOfDivisors.size() - 1, currentNumberOfDivisors);	
							highlyCompositeNumber.set(highlyCompositeNumber.size() - 1, i);
						}
						else {
							numberOfDivisors.add(currentNumberOfDivisors);
							highlyCompositeNumber.add(i);
						}
					}
				}
			}
		}

		/* numberOfDivisors++ for the ArrayList
		   Reason for that is that the program never added the HCN itself to the number of divisors that it has */
		for (int i = 0; i < numberOfDivisors.size(); i++) {
			numberOfDivisors.set(i, (numberOfDivisors.get(i) + 1));
		}

		System.out.println("The highly composite numbers and their number of divisors are:");
		for (int i = 0; i < highlyCompositeNumber.size(); i++) {
			System.out.println(highlyCompositeNumber.get(i) + "\t" + numberOfDivisors.get(i));
		}
		System.out.println("Which comes out to " + highlyCompositeNumber.size() + " total highly composite numbers.");
	}

	static final Scanner keyboardInput = new Scanner(System.in);
	static String tempStringInput;

	public static int IntHandler() {
		tempStringInput = keyboardInput.nextLine();
		while (true) {
			try {
				int intInput = Integer.parseInt(tempStringInput);
				return intInput;
			}
			catch (Exception exception) {
				System.out.println("Please enter a valid integer.");
				IntHandler();
			}
		}
	}
}
