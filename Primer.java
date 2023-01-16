import java.util.Scanner;
import java.util.ArrayList;

public class Primer {
	
	public static void main (String[] args) {
		System.out.println("This program prints all the prime numbers within a specified range.");
		System.out.println("Please enter the upper bound.");

		//2 is the lowest prime
		final int lowerBound = 2;
		int upperBound = IntHandler();

		ArrayList<Integer> primes = new ArrayList<Integer>();
		//Adding 2 because the ArrayList shouldn't be null for when calculating primes.
		primes.add(2);

		//Exit condition 
		if (upperBound < lowerBound) {
			System.out.println("Illegal upper bound. Quitting.");
			System.exit(0);
		}

		//To be pedantic, this could be an if statement and there wouldn't be a difference.
		//I googled it and calculating primes is surprisingly easier than one'd think.
		else if (upperBound != lowerBound) {
			for (int i = lowerBound; i <= upperBound; i++) {
				boolean isPrime = true;
				//The (&& isPrime) is really important for efficiency
				for (int j = 0; (j < primes.size()) && isPrime; j++) {
					//To be even more pedantic, this checks if a number is *not* a prime
					if (i % primes.get(j) == 0) {
						isPrime = false;
					}
				}

				if (isPrime) {
					primes.add(i);
				}
			}
		}

		System.out.println("The primes until " + upperBound + " are:");
		for (int i = 0; i < primes.size(); i++) {
			System.out.println(primes.get(i));
		}
		System.out.println("Which comes out to " + primes.size() + " total prime numbers.");
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
				return IntHandler();
			}
		}
	}
}
