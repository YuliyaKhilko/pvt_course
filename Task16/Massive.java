package core;

public class Massive {

	// finds and returns max array element
	public int max(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	// finds and returns min array element
	public int min(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	// calculates and returns sum of array elements
	public int sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		return result;
	}

	// calculates and returns multiplication of array elements, if there are zero
	// elements - simply returns 0
	public int multiplication(int[] array) {
		int result = 1;
		int a = 0;
		int count = 0;
		while (a < array.length) {
			if (array[a] == 0) {
				count++;
			}
			a++;
		}
		if (count != 0) {
			return 0;
		} else {
			for (int i = 0; i < array.length; i++) {
				result *= array[i];
			}
			return result;
		}
	}

	// divides each array element by some number and rounds the result
	public int[] elementDivided(int[] array, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException();
		} else {
			for (int i = 0; i < array.length; i++) {
				array[i] = Math.round((float) array[i] / divisor);
			}
			return array;
		}
	}

	// counts zero elements, throws custom exception if there are no zero elements
	public int countZeroElements(int[] array) throws NoZeroElementsException {
		int a = 0;
		int count = 0;
		while (a < array.length) {
			if (array[a] == 0) {
				count++;
			}
			a++;
		}
		if (count != 0) {
			return count;
		} else {
			throw new NoZeroElementsException();
		}
	}

	// multiples each element by some number and returns the result array
	public int[] elementsMultiplied(int[] array, int multiplier) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * multiplier;
		}
		return array;
	}

	// adds to each element some number and returns the result array,
	// if incrementer is Zero -> just returns the initial array
	public int[] elementsIncreased(int[] array, int incrementer) {
		if (incrementer == 0) {
			return array;
		} else {
			for (int i = 0; i < array.length; i++) {
				array[i] = array[i] + incrementer;
			}
			return array;
		}
	}

	// substracts some number from each element and returns the result array
	// if incrementer is Zero -> just returns the initial array
	public int[] elementsDecreased(int[] array, int decrementer) {
		if (decrementer == 0) {
			return array;
		} else {
			for (int i = 0; i < array.length; i++) {
				array[i] = array[i] - decrementer;
			}
			return array;
		}
	}

	// checks if the max element is Even or Odd
	public boolean isEvenMaxElement(int[] array) {
		int max = array[0];
		boolean isEven;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		isEven = (max % 2 == 0) ? true : false;
		return isEven;
	}

}
