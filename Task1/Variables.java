
public class Variables {

	public static void main(String[] args) {
		int number1 = 200000;
		short number2 = 30000;
		long number3 = 5000000000l;
		double number4 = 100.50;
		float number5 = 1500.125f;
		char letter = 'M';
		boolean bool = true;
		int result1 = number1 + number2;
		double result2 = number3 - number4;
		double result3 = number5 * number4;
		boolean result4 = number3 > number4;
		boolean result5 = number5 < number1;
		boolean result6 = number1 == number2;
		boolean result7 = number3 != number5;
		System.out.println(number1 + " " + number2 + " " + number3 + " " + number4 + " " + number5);
		System.out.println(letter + " " + bool);
		System.out.print(result1 + " " + result2 + " " + result3 + " ");
		System.out.print(result4 + " " + result5 + " " + result6 + " " + result7);
		System.out.printf("\n" + "%.2f", number5);
	}

}
