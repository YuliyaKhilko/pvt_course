// 9. найти номер минимального-максимального элементов и вывести

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
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
		System.out.print("Max elements numbers: ");
		for (int i = 0; i < array.length; i++) { // added this for as there could be more than one element with the same max value
			if (array[i] == max) {
				System.out.print((i + 1) + " "); 
			}
		}
		System.out.print("\n" + "Min elements numbers: "); // added this for as there could be several elements with the same min value
		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) {
				System.out.print((i + 1) + " ");
			}
		}

		scanner.close();
	}

}
