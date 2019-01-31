package core.massive;

public class Massive {

	// prints massive in direct order
	public void printMassiveAsLine(int[] mas1) {
		System.out.println("in direct order: ");
		for (int i = 0; i < mas1.length; i++) {
			System.out.print(mas1[i] + " ");
		}
	}

	// prints massive in reverse order
	public void printReverseMassiveAsLine(int[] mas) {
		System.out.println("\n in reverse order: ");
		for (int i = mas.length - 1; i >= 0; i--) {
			System.out.print(mas[i] + " ");
		}
	}

	// returns sum of elements
	public int getSumOfElements(int[] mas) {
		int result = 0;
		for (int i = 0; i < mas.length; i++) {
			result = result + mas[i];
		}
		return result;
	}

	// returns array with every element multiplied by 3
	public int[] multiptyBy3(int[] mas) {
		int[] mas2 = mas.clone();
		for (int i = 0; i < mas2.length; i++) {
			int multiplier = 3;
			mas2[i] *= multiplier;
		}
		return mas2;
	}
}
