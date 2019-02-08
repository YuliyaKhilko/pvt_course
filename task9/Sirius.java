package core;

public class Sirius extends Star {
	long temparature;
	double distanceFromEarth;

	public void printTemperature() {
		System.out.println(temparature);
	}

	public void printDistanceFromEarth() {
		System.out.println(distanceFromEarth);
	}

	// Другой - систему сеттеров и геттеров и инициализироваться при помощи их.
	long getTemparature() {
		return temparature;
	}

	void setTemparature(long temparature) {
		this.temparature = temparature;
	}

	double getDistanceFromEarth() {
		return distanceFromEarth;
	}

	void setDistanceFromEarth(double distanceFromEarth) {
		this.distanceFromEarth = distanceFromEarth;
	}

}
