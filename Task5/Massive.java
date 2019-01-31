package core;

import java.util.Arrays;
import java.util.Scanner;

public class Massive {

	// Fill massive with random int values
	public static int[] getArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			int rangeEnd = 10;
			array[i] = (int) (Math.random() * rangeEnd);
		}
		scanner.close();
		return array;
	}

	// print array
	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	// Insertion Sort

	public static int[] insertionSort(int[] array) {
		int[] array2 = array.clone();
		for (int i = 0; i < array2.length; i++) {
			int currentValue = array2[i];
			int indexPrevious = i - 1;
			while (indexPrevious >= 0 && currentValue < array2[indexPrevious]) {
				array2[indexPrevious + 1] = array2[indexPrevious];
				array2[indexPrevious] = currentValue;
				indexPrevious--;
			}
		}
		return array2;
	}

}
