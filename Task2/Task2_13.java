/* Дополнительное задание:
1. По аналогии создать двумерный массив, заполнить его случайными числами или вручную. для этого массива:
- вывести все элементы в прямом и обратном порядке
- найти минимальный и максимальный элементы
*/

package core;

import java.util.Scanner;

public class Task2_13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows:");
		int numberOfRows = scanner.nextInt();
		System.out.println("Enter number of columns:");
		int numberOfColumns = scanner.nextInt();
		int[][] array = new int[numberOfRows][numberOfColumns];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}
		System.out.println("Generated array: ");
		for (int i = 0; i < array.length; i++, System.out.println()) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		System.out.println("Array in the reverse order: ");
		for (int i = array.length - 1; i >= 0; i--, System.out.println()) {
			for (int j = array[i].length - 1; j >= 0; j--) {
				System.out.print(array[i][j] + " ");
			}
		}
		int max = array[0][0];
		int min = array[0][0];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] < min) {
					min = array[i][j];
				}
			}
		}
		System.out.println("Max element = " + max + "\n" + "Min element = " + min);
		scanner.close();
	}

}
