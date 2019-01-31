//3. каждый 3-й элемент умножить на 2 (2-мя способами)

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type array size:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		int a = 0;
		while (a < array.length) {
			System.out.println("Type the value for next array element:");
			int array_element = scanner.nextInt();
			array[a] = array_element;
			a++;
		}
		System.out.println("Your array:" + Arrays.toString(array));
		for (int i = 1; i <= array.length; i++) {
			if (i % 3 == 0) {
				array[i - 1] *= 2;
			}
		}
		System.out.println("1st method:" + Arrays.toString(array));
		for (int i = 2; i < array.length; i += 3) {
			array[i] *= 2;
		}
		System.out.println("2nd method" + Arrays.toString(array));
		scanner.close();
	}

}
