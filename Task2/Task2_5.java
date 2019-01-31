//5. найти и вывести номер нулевых элементов. если нулевых элементов нет - вывести сообщение, что их нет

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_5 {

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
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				System.out.println(i+1); // to display order number not index
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No zero elments");
		}
		scanner.close();
	}

}
