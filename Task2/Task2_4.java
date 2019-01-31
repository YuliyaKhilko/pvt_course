//4. найти количество нулевых элементов, вывести количество. если нулевых элементов нет - вывести сообщение, что их нет

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		System.out.println("Generated array: " + Arrays.toString(array));
		int a = 0;
		int count = 0;
		while (a < array.length) {
			if (array[a] == 0) {
				count++;
			}
			a++;
		}
		if (count != 0) {
			System.out.println("Zero lements count: " + count);
		} else {
			System.out.println("No zero elements");
		}
		scanner.close();
	}

}
