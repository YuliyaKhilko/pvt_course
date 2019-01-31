//7.  пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д. 

package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		System.out.println("Generated array: " + Arrays.toString(array));
		int additional = 0;
		for(int i = 0; i < array.length/2; i++) {
			additional = array[i];
			array[i] = array[size - 1 - i];
			array[size - 1 - i] = additional;
		}
		System.out.println("Result: " + Arrays.toString(array));
		scanner.close();
	}

}
