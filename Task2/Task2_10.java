// 10. проверить, является ли массив возрастающей последовательностью (каждое следующее число больше предыдущего)

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		System.out.println("Generated array: " + Arrays.toString(array));
		int count = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				count++;
			}
		}
		if (count == array.length - 1) {
			System.out.println("Increasing progression");
		} else {
			System.out.println("NOT increasing progression");
		}

	}

}
