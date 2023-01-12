//package Algorithms;
public class Sort {
	public static int[] Bubble(int[] integerArray) {	
		//Sorting
		/* Been a while since I worked on this, but I think the reason this exists is because without it the program would do one extra iteration
		   Now whether that's more efficient I don't know. */
		boolean isProgramRunning = true;
		for (int i = 0; i < integerArray.length && isProgramRunning; i++) {
			isProgramRunning = false;
			for (int j = 0; j < integerArray.length - 1; j++) {
				if (integerArray[j] > integerArray[j + 1]) {
					isProgramRunning = true;

					int temp = integerArray[j];
					integerArray[j] = integerArray[j + 1];
					integerArray[j + 1] = temp;
				}
			}
		}
		
		return integerArray;
	}

	public static int[] Selection(int[] integerArray) {
		for (int i = 0; i < integerArray.length - 1; i++) {
			int smallestElement = i;
			for (int j = i; j < integerArray.length; j++) {
				if (integerArray[i] > integerArray[j]) {
					smallestElement = j;
				}
			}

			int temp = integerArray[smallestElement];
			integerArray[smallestElement] = integerArray[i];
			integerArray[i] = temp;
		}

		return integerArray;
	}
}
		