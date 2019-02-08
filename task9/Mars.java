package core;

public class Mars extends Planet {
	long distanceFromEarth;
	int coreRadius;

	// Третий - перегруженные, но не связанные друг с другом конструкторы и
	// создаваться при помощи одного из них на выбор.
	public Mars(int diametr, double distanceFromSun, int coreRadius, long distanceFromEarth) {
		super(diametr, distanceFromSun);
		this.coreRadius = coreRadius;
		this.distanceFromEarth = distanceFromEarth;
	}

	public Mars(int coreRadius) {
		this.coreRadius = coreRadius;
	}

	public void printDistanceFromEarth() {
		System.out.println(distanceFromEarth);
	}

	public void printCoreRadius() {
		System.out.println(coreRadius);
	}

}
