package core;

public class Tester {

	/*
	 * Создать класс Tester со следующими полями: -name -surname -expirienceInYears
	 * -englishLevel -salary Самостоятельно решить, какое модификатор доступа будет
	 * иметь каждое из полей, при этом использовать все изученные модификаторы.
	 */
	public String name;
	String surname;
	int expirienceInYears;
	protected String englishLevel;
	private int salary;

	/*
	 * 1. Перегрузить в этом классе 3 конструктора, каждый из которых будет
	 * последовательно вызывать другой используя this(...); Конструктор с наибольшим
	 * числом параметров сделать с уровнем доступа отовсюду.
	 */
	protected Tester(String name, String surname) {
		this(name, surname, 0, "beginner");
	}

	private Tester(String name, String surname, int expirienceInYears, String englishLevel) {
		this(name, surname, expirienceInYears, englishLevel, 100);
	}

	public Tester(String name, String surname, int expirienceInYears, String englishLevel, int salary) {
		this.name = name;
		this.surname = surname;
		this.expirienceInYears = expirienceInYears;
		this.englishLevel = englishLevel;
		this.salary = salary;
	}
	// 2. Написать для каждого поля get- и set- методы с уровнем доступа только
	// внутри пакета.

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	int getExpirienceInYears() {
		return expirienceInYears;
	}

	void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}

	// 3. Написать метод с уровнем доступа только внутри класса, который будет
	// возвращать salary*2;

	private int doubledSalary() {
		int salaryMultipler = 2;
		return salary * salaryMultipler;
	}

	// 4. Написать метод с уровнем доступа только внутри пакета, который будет
	// возвращать количество опыта в месяцах;
	int experienceInMonths() {
		int monthInYear = 12;
		return expirienceInYears * monthInYear;
	}

	// 5. Написать метод с уровнем доступа внутри пакета и для наследников в других
	// пакетах, который выводит на экран имя и фамилию;

	protected void printName() {
		System.out.println(String.format("Name: %s, Surname: %s", name, surname));
	}

	// 6. Написать метод с уровнем доступа отовсюду, который в одну строку будет
	// выводить всю информацию о пользователе.
	public void printAllInfo() {
		System.out
				.println(String.format("Name: %s, Surname: %s, expirience in years: %s, english level: %s, salary: %s",
						name, surname, expirienceInYears, englishLevel, salary));
	}

}
