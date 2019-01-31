package core;

public class Person {
	String name;
	String surname;
	int age;
	String phone;

	// sets name
	public void setName(String name) {
		this.name = name;
	}

	// sets surname
	public void setSurname(String surname) {
		this.surname = surname;
	}

	// sets age
	public void setAge(int age) {
		this.age = age;
	}

	// sets phone
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// prints name + surname + age + phone
	public void printAllInformation() {
		System.out.println("Name: " + name + " Surname: " + surname + " Age: " + age + " Phone: " + phone);
	}

	// prints name + surname
	public void printName() {
		System.out.println("Name: " + name + " Surname: " + surname);
	}

	// returns true/false depending on object name (> 18);
	public boolean isAdult() {
		if (age > 18) {
			return true;
		} else
			return false;
	}
}
