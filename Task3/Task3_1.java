/* Общее домашнее задание
Методы:
Создать класс со следующими статическими методами: 
 1 Найти минимальное число из 2 чисел, вернуть минимальное
 2 Проверить четное число или нечетное, вернуть boolean результат
 3 Возвести число в квадрат, вернуть результат возведения
 4 Возвести число в куб, вернуть результат возведения

Все методы должны возвращать значения нужного типа. 
Примеры использования этих методов привести в main- методе текущего класса. 
Числа для работы генерируется автоматически используя Random или пользователь вводит их с клавиатуры.*/

package core;

import java.util.Scanner;

public class Task3_1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Type number 1: ");
		int number1 = scanner.nextInt();
		System.out.println("Type number 2: ");
		int number2 = scanner.nextInt();

		// get min number of 2
		System.out.println("Min number: " + getMin(number1, number2));

		// check if number is even/odd
		if (isEven(number1) == true) {
			System.out.println("Number " + number1 + " is even");
		} else {
			System.out.println("Number " + number1 + " is odd");
		}

		// get square for number
		System.out.println("Square = " + getSquare(number1)); // 3

		// get cube for number
		System.out.println("Cube = " + getCube(number1)); // 4

		scanner.close();
	}

	// returns min number of 2
	public static int getMin(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

	// checks if number is even/odd
	public static boolean isEven(int a) {
		boolean isEven;
		if (a % 2 == 0) {
			isEven = true;
		} else {
			isEven = false;
		}
		return isEven;
	}

	// returns square
	public static int getSquare(int a) {
		return (int) Math.pow(a, 2);
	}

	// returns cube
	public static int getCube(int a) {
		return (int) Math.pow(a, 3);
	}

}
