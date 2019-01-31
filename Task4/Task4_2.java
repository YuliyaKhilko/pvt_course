package core.massive;

public class Task4_2 {

	public static void main(String[] args) {
		Massive massive = new Massive();
		// create massive with random int values from 0 to 10
		int size = 5;
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			int rangeStart = 0;
			int rangeEnd = 10;
			array[i] =  rangeStart + (int) (Math.random() * rangeEnd);
		}
		
		massive.printMassiveAsLine(array);
		
		massive.printReverseMassiveAsLine(array);
		
		System.out.println("\nSum of elements= " + massive.getSumOfElements(array));
		
		int[] array2 = massive.multiptyBy3(array);
		System.out.print("Array with elements multiplied by 3 ");
		massive.printMassiveAsLine(array2);
		
	}

}
