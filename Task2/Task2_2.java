//2.  найти произведения всех элементов массива, вывести

package core;

import java.util.Scanner;

public class Task2_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1); // to generate numbers from 1 to 10
			System.out.println(array[i]);

		}
		int result = 1;
		for (int i = 0; i < array.length; i++) {
			result *= array[i];
		}
		System.out.println(result);
		scanner.close();
	}

}
