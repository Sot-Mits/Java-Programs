import java.util.Scanner;


public class ParityGen {
	public static void main(String[] args) {
		//Intro
		Scanner keyboardInput = new Scanner(System.in);

		//Takes Parity Method
		System.out.println("Java");
		System.out.println("This program prints a parity bit on a binary 8-bit integer");
	    System.out.println("Even (0) or Odd (1) Parity Bit?");

		//Declare variables in the farthest scope you'll use them in
		int parityMethod;
		while (true) {
    		try {
    			parityMethod = keyboardInput.nextInt();

	    		if (parityMethod == 0) {
    				System.out.println("You have chosen the Even Parity Check");
    				break;
    			} 
	    		else if (parityMethod == 1) {
    				System.out.println("You have chosen the Odd Parity Check");
    				break;
	    		}
    			//In case input is invalid
    			else {
    				System.out.println("Please enter either 0 or 1");
				}
    		}		
	    	catch(Exception A) {
				keyboardInput.nextLine();
    			System.out.println("Please enter an integer value");
			}
    	}

		//Checks that input is legal 
		//caveman mode engaging
		String userInput;
		while (true) {
			System.out.println("Please enter 7 bits");
			//Takes User Input
			userInput = keyboardInput.next();

			//Checks Length
			boolean legalLength = false;  
			if (userInput.length() == 7){
				legalLength = true;
			}

			//checks for 1's and 0's
			//After a few months, I forgor wtf I did
			int i = 0;
			boolean legalInput = true;
			while (i < userInput.length()) {
				//char userInputChar = userInput.charAt(i);
				if ((userInput.charAt(i) != '0') && (userInput.charAt(i) != '1')) {
					legalInput = false;
				}
				i++;
			}
			
			if ((legalLength == true) && (legalInput == true)) {
				System.out.println("You have entered 7 bits");
				break;
			}
			else if ((legalLength == true) && (legalInput == false)) {
				System.out.println("You have entered 7 characters, but they're not bits");
			}
			else if ((legalLength == false) && (legalInput == true)) {
				System.out.println("You have entered an incorrect amount of bits");
			}
			else if ((legalLength == false) && (legalInput == false)) {
				System.out.println("You have entered neither 7 characters, nor bits");
			}
		}
	
		//caveman mode disengaging
		//I could've used switch statements but I tried to make it as comprehensible as possible

		//Genarating Parity Bit
		//Reusing i because I don't need to worry about it clashing with its previous instance
		int numberOfOnes = 0;
		int i = 0;
		while (i < 7) {
			if ((userInput.charAt(i) == '1')) {
				numberOfOnes++;
			}
			i++;
		}
		int parityBit = (((numberOfOnes % 2) + parityMethod) % 2);

		//Adding Parity Bit & printing
		String transmittedByte = userInput + Integer.toString(parityBit); // or String.valueOf()
		System.out.println("Transmitted byte will be " + transmittedByte);

		keyboardInput.close();


	}
}