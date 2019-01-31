// 12. циклически сдвинуть все элементы вправо на 2 позиции (1-й элемент станет 3-м, 2-й стент 4-м и т.д.)

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_12 {

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
		for (int i = 0; i < array.length; i++) { 
			if (i > 1 && i < array.length) {
				newArray[i] = array[i-2];
			} else {
				newArray[i] = 0;  // sets first two elements to 0 as there is nothing to move into them
			}
		}
		System.out.println("Result: " + Arrays.toString(newArray));
		scanner.close();
	}

}
