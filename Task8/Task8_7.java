package core;

public class Task8_7 {

	/*
	 * 7. В методе main другого класса (любого), лежащего в том же пакете что и
	 * Tester, создать объект класса Tester, используя любой из перегруженных
	 * конструкторов. продемонстрировать последовательный вызов всех методов класса
	 * Tester, если это возможно. если невозможно - написать комментарий почему.
	 */
	public static void main(String[] args) {
		Tester tester = new Tester("Yuliya", "Khilko");
		// tester.doubledSalary(); - method is private
		tester.experienceInMonths();
		tester.printName();
		tester.printAllInfo();
		
		ClosedTester.create();
		
	}

}
