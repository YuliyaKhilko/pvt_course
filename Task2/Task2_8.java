// 8. найти минимальный-максимальный элементы и вывести

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		int max = array[0];
		int min = array[0];
		System.out.println("Generated array: " + Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("Max element = " + max + "\n" + "Min element = " + min);
		scanner.close();
	}

}
