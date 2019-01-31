package core;

public class Task4_1 {

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Yuliya");
		person.setSurname("Khilko");
		person.setAge(26);
		person.setPhone("111-44-79");
		
		person.printAllInformation();
		person.printName();
		
		if (person.isAdult() == true) {
			System.out.println("Person is adult");
		}
		else {
			System.out.println("Person is not adult");
		}

	}

}
