//1. пройти по массиву, вывести все элементы в прямом и в обратном порядке

package core;

import java.util.Scanner;

public class Task2_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		double[] array = new double[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random();
			System.out.println(array[i]);
		}
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
		scanner.close();
	}
}
