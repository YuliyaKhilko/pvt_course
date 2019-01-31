// 11. заменить все элементы массива на полусумму соседних элементов

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println("Generated array: " + Arrays.toString(array));
		int[] newArray = new int[size];
		for (int i = 0; i < array.length; i++) { // first and last elements stay the same as they have only 1 neighbor
			if (i > 0 && i < array.length - 1) {
				newArray[i] = (array[i + 1] + array[i - 1]) / 2;
			} else {
				newArray[i] = array[i];
			}
		}
		System.out.println("Result: " + Arrays.toString(newArray));
		scanner.close();
	}
}
