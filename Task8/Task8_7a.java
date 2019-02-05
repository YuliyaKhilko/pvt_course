package other;

import core.Tester;

public class Task8_7a {

	/*
	 * 7а. Повторить вышеописанные действия, однако класс с методом main вынести в
	 * другой пакет.
	 */
	public static void main(String[] args) {
		Tester tester = new Tester("Yuliya", "Khilko", 0, "beginner", 100);
		// tester.doubledSalary(); - method is private
		// tester.experienceInMonths(); - method is friendly, not accessible from another package
		// tester.printName(); - - method is protected, not accessible from another package
		tester.printAllInfo();

	}

}
