public class Search {
	public static int Linear(int[] integerArray, int integerToFind) {		
		for (int i = 0; i < integerArray.length; i++) {
			if (Start.searchedInt == integerArray[i]) {
				return i;
				//break;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static int Binary(int[] integerArray, int integerToFind) {
		int lowerBound = 0;
		int upperBound = integerArray.length - 1;

		while ((upperBound - lowerBound) > 1) {
			int searchMiddle = (upperBound + lowerBound) / 2;

			if (integerArray[searchMiddle] < integerToFind) {
				lowerBound = searchMiddle + 1;
			}
			else {
				upperBound = searchMiddle;
			}
		}

		if (integerArray[lowerBound] == integerToFind) {
			return lowerBound;
		}
		else if (integerArray[upperBound] == integerToFind) {
			return upperBound;
		}
		else {
			return Integer.MIN_VALUE;
		}
	}
}
