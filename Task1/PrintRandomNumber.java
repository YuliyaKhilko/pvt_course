package core;

import java.util.Random;

public class PrintRandomNumber {
	public static void main(String[] args) {
		Random generator = new Random();
		int randomNumber = generator.nextInt(1000000);
		System.out.println("Random number = " + randomNumber);
	}

}
