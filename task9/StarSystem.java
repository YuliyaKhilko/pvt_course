package core;

public abstract class StarSystem {
	String name;
	String type;

	public void printName() {
		System.out.println(name);
	}

	public void printType() {
		System.out.println(type);
	}

	abstract void printMessage();

}
