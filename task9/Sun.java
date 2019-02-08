package core;

public class Sun extends Star {
	double luminosity;
	double energyProduction;

	// Один из классов на выбор должен содержать перегруженные связанные друг с
	// другом конструкторы (используя this) и создаваться с их помощью.

	public Sun(double luminosity) {
		this(luminosity, 0.1925);
	}

	public Sun(double luminosity, double energyProduction) {
		this.luminosity = luminosity;
		this.energyProduction = energyProduction;
	}

	public void printLuminosity() {
		System.out.println(luminosity);
	}

	public void printEnergyProduction() {
		System.out.println(energyProduction);
	}

}
