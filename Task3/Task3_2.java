package core;

import java.util.Scanner;

public class Task3_2 {

	public static void main(String[] args) {
		int[] mas1 = getArray();
		printArrayInDirectOrder(mas1);
		
		printArrayInReverseOrder(mas1);
		
		System.out.println("multiply of array elements = " + getMultiplyOfArrayElements(mas1));
		
		getArrayWithEachThirdElementDoubled(mas1);
		printArrayInDirectOrder(mas1);
		
		System.out.println("There are " + getNumerOfZeroElements(mas1) + " zero elements in your array");
		
		printNumbersOfzeroElements(mas1);
		
		getArrayWithSwappedElements(mas1);
		printArrayInDirectOrder(mas1);
		
		System.out.println("The value of max element in your array: " + getValueOfMaxElement(mas1));
		
		System.out.println("The value of min element in your array: " + getValueOfMinElement(mas1));
		
		System.out.println("The number of element with max value = " + getNumberOfMaxElement(mas1));
		
		System.out.println("The number of element with min value = " + getNumberOfMinElement(mas1));
		

	}
	// generates new array with random elements from 0 to 10
	public static int[] getArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array length:");
		int size = scanner.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			int arrayRangeFrom = 0; 
			int arrayRangeTo = 10; 
			array[i] = arrayRangeFrom + (int) (Math.random() * arrayRangeTo);
		}
		scanner.close();
		return array;
	}
	// prints array elements to console 
	public static void printArray(int [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	// prints array in direct order
	public static void printArrayInDirectOrder (int[] array) {
		System.out.println ("In direct order:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	// prints array in reverse order
	public static void printArrayInReverseOrder (int[] array) {
		System.out.println ("In reverse order:");
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
	}
	// returns multiply of all array elements
	public static int getMultiplyOfArrayElements (int[] array) {
		int result = 1;
		for (int i = 0; i < array.length; i++) {
			result =  result * array[i];
		}
		return result;
	}
	// returns array with each third element multiplied by 2
	public static int[] getArrayWithEachThirdElementDoubled (int[] array ) {
		System.out.println ("Array with each third element multipled by 2");
		int[] array2 = array;
		for (int i = 2; i < array2.length; i += 3) {
			array2[i] *= 2;
		}
		return array2;
	}
	// returns number of zero elements in array
	public static int getNumerOfZeroElements(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				count++;
			}
		}
		return count;
		}
	// prints numbers of zero elements
	public static void printNumbersOfzeroElements (int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				System.out.println(i+1); 
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No zero elments");
		}
	}
	// returns array with swapped every two elements
	public static int[] getArrayWithSwappedElements (int[] array) {
		System.out.println ("Array with swapped every two elements");
		int temp;
		for(int i = 0; i < array.length - 1; i += 2) { 
			temp = array [i];
			array[i] = array[i + 1];
			array[i + 1] = temp;
		}
		return array;
	}
	// returns the value of max element in array
	public static int getValueOfMaxElement (int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	// returns the value of min element in array
	public static int getValueOfMinElement (int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	// returns number of elements with max value
	public static int getNumberOfMaxElement (int[] array) {
		int maxElement = array[0];
		int numberOfMaxElement = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxElement) {
				maxElement = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) { 
			if (array[i] == maxElement) {
				 numberOfMaxElement = i + 1; 
			}
		}
		return numberOfMaxElement;
	}
	// returns number of elements with min value
		public static int getNumberOfMinElement (int[] array) {
			int minElement = array[0];
			int numberOfMinElement = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] < minElement) {
					minElement = array[i];
				}
			}
			for (int i = 0; i < array.length; i++) { 
				if (array[i] == minElement) {
					 numberOfMinElement = i + 1; 
				}
			}
			return numberOfMinElement;
		}
}
