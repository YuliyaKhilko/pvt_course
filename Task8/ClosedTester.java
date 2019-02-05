package core;

/*
 * Дополнительное домашнее задание:
 * Написать такой конструктор, который запретит создание объекта класса Tester в других классах;
 */
public class ClosedTester {
	public String name;
	String surname;
	int expirienceInYears;
	protected String englishLevel;
	private int salary;

	// private constructor can not be called from any different class
	private ClosedTester() {

	}

	/*
	 * Найти способ вызывать методы класса Tester, который позволит обойти
	 * ограничение, наложенное конструктором выше.
	 */
	// public static method can be called from other class without creating object
	// and it has access to private constructor because they are in the same class
	public static ClosedTester create() {
		ClosedTester tester = new ClosedTester();
		return tester;
	}

}
