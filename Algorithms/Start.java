import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.File;

public class Start {

	static int userInput;

	public static int searchedInt;
	static int indexNumber = Integer.MIN_VALUE;

	static int[] unsortedArray = FileConverter("input.txt");
	public static int[] sortedArray;

	//Search search = new Search();
	//Sort sort = new Sort();

	public static void main(String[] args) {
		System.out.println("Do you want to leave the array be (1), bubble sort it (2), or selection sort it (3)?");
		boolean enteredSort = false;
		do {
			userInput = IntHandler();
			System.out.println();
			switch (userInput) {
				case 1:
				System.out.println("Warning: Array not sorted.");
				System.out.println("This can cause unwanted effects when searching through the array.");
				sortedArray = unsortedArray;
				enteredSort = true;
				break;

				case 2:
				System.out.println("Using bubble sort.");
				sortedArray = Sort.Bubble(unsortedArray);
				System.out.println("Sorted.");
				enteredSort = true;
				break;

				case 3:
				System.out.println("Using selection sort.");
				sortedArray =  Sort.Bubble(unsortedArray);
				System.out.println("Sorted.");
				enteredSort = true;
				break;
		
				default:
				System.out.println("Please enter an integer between 1 and 3.");
			}
		} while (!enteredSort);

		for (int i = 0; i < sortedArray.length - 1; i++) {
			System.out.print(sortedArray[i] + ", ");
		}
		System.out.println(sortedArray[sortedArray.length - 1]);

		System.out.println("Do you want to not search array (1), linear search it (2), or binary search it (3)?");
		boolean enteredSearch = false;
		do {
			userInput = IntHandler();
			System.out.println();
			switch (userInput) {
				case 1:
				//enteredSearch = true;
				System.exit(0);
				break;

				case 2:
				System.out.println("Please enter a value to search for.");
				searchedInt = IntHandler();
				indexNumber = Search.Linear(sortedArray, searchedInt);
				enteredSearch = true;
				break;

				case 3:
				System.out.println("Please enter a value to search for.");
				searchedInt = IntHandler();
				indexNumber =  Search.Binary(sortedArray, searchedInt);
				enteredSearch = true;
				break;
		
				default:
				System.out.println("Please enter an integer between 1 and 3.");
			}
		} while (!enteredSearch);

		if (indexNumber != Integer.MIN_VALUE) {
			System.out.println(searchedInt + " is in index " + indexNumber);
		}
		else {
			System.out.println(searchedInt + " doesn't exist in array.");
		}
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

	static int[] FileConverter(String fileName) {
		//ArrayList<Integer> fileContents = new ArrayList<Integer>();
		//Scanner reader;
		//String line;

		try {
			//Checks for file
			//I'm doing this on Mac so I can't confirm but I think for Windows it should be without File.separator
			Scanner reader = new Scanner(new File(/*System.getProperty("user.dir") + File.separator + */fileName));

			//Checks for empty file
			String line = reader.next();

			//Checks for something other than integer
			ArrayList<Integer> fileContents = new ArrayList<Integer>();
			fileContents.add(Integer.parseInt(line));

			//If everything goes well program will end up here and eventually cause an (expected) exception
			try {
				while (true) {
					line = reader.next();
					fileContents.add(Integer.parseInt(line));
				}
			}

			//When the program goes here it signifies the array has been copied over
			catch (NoSuchElementException endOfArrayException) {
				System.out.println("Array copied.");
				reader.close();

				int[] arrayListToArray = new int[fileContents.size()];
				for (int i = 0; i < arrayListToArray.length; i++) {
					arrayListToArray[i] = fileContents.get(i);
				}

				for (int i = 0; i < arrayListToArray.length - 1; i++) {
					System.out.print(arrayListToArray[i] + ", ");
				}
				System.out.println(arrayListToArray[arrayListToArray.length - 1]);

				System.out.println();
				return arrayListToArray;
			}
		} 

		//Exception for no file
		catch (FileNotFoundException fileException) {
			System.out.println("Enter a file.");
			System.out.println("Make sure the file is called \"input.txt\" and you're in the correct directory.");
			System.exit(0);
		}

		//Exception for empty file
		catch (NoSuchElementException elementException) {
			System.out.println("File is empty.");
			System.exit(0);
		}

		//Exception for something other than integer
		catch (NumberFormatException intException) {
			System.out.println("Not an array.");
			System.out.println("Make sure the integers are separated by a singular whitespace.");
			System.exit(0);
		}

		System.out.println("Something went wrong :(");
		System.exit(0);
		//Java is being annoying and wants a return here
		return null;
	} 
}
