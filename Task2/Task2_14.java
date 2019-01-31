/* Дополнительное задание 2:
Создать список ArrayList, заполнить его строковыми или числовыми значениями. при помощи цикла for each:
 - вывести все элементы списка
 - к каждому из элементов прибавить любое число (или строку, если список строковый)
 - удалить последовательно все элементы
 - удалить сразу все элементы */

package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task2_14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many elements will be in your list?");
		int size = scanner.nextInt();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < size; i++) { // fill the list from console
			System.out.println("Enter next list element: ");
			arrayList.add(i, scanner.next());
		}
		for (int i = 0; i < arrayList.size(); i++) { // print the list
			System.out.println(arrayList.get(i));
		}
		for (int i = 0; i < arrayList.size(); i++) { // add "!" to each element
			arrayList.set(i, arrayList.get(i) + "!");
		}
		System.out.println("Edited list: " + arrayList);
		arrayList.clear(); // remove all element from the list
		System.out.println("Your list is empty now: " + arrayList);

	}
}
