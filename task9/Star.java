package core;

public class Star extends StarSystem {
	long mass;
	long volume;

	public void printMass() {
		System.out.println(mass);
	}

	public void printVolume() {
		System.out.println(volume);
	}

	@Override
	void printMessage() {
		System.out.println("Hello from star");

	}

}
