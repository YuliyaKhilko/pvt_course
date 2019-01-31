/* Общее домашнее задание
Создать класс Tester со следующими полями:
-name
-surname
-expirienceInYears
-englishLevel
-salary */

package core;

public class Tester {
	String name;
	String surname;
	int experienceInYears;
	String englishLevel;
	int salary;
	public static int age = 27;

	/* 1. Перегрузить в этом классе 3 конструктора, каждый из которых будет
	 * последовательно вызывать другой используя this(...);
	 */

	public Tester(String name) {
		this.name = name;
	}

	public Tester(String name, String surname) {
		this(name);
		this.surname = surname;
	}

	public Tester(String name, String surname, int experienceInYears) {
		this(name, surname);
		this.experienceInYears = experienceInYears;
	}

	public Tester(String name, String surname, int experienceInYears, String englishLevel, int salary) {
		this(name, surname, experienceInYears);
		this.englishLevel = englishLevel;
		this.salary = salary;
	}

	// 2. Написать 3 любых перегруженных метода в этом классе

	public void setInfo(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public void setInfo(int experienceinYears) {
		this.experienceInYears = experienceinYears;
	}

	public void setInfo(String englishLevel, int salary) {
		this.salary = salary;
		this.englishLevel = englishLevel;
	}

	// 3. Написать статический метод и показать пример его корректного вызова в
	// другом классе

	public static int getAge() {
		return age;
	}
}
