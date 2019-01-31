package core;

public class Task5_3 {

	public static void main(String[] args) {
		int[] mas = Massive.getArray();
		System.out.println("Not sorted array:");
		Massive.printArray(mas);
		
		int [] masSorted = Massive.insertionSort(mas);
		System.out.println("Sorted array:");
		Massive.printArray(masSorted);
		
	}

}
