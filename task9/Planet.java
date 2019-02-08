/*
 * Один из классов на выбор должен содержать перегруженные связанные друг
 *  с другом конструкторы (используя this) и создаваться с их помощью.
 */

package core;

public class Planet extends StarSystem {

	int diametr;
	double distanceFromSun;

	public Planet() {

	}

	public Planet(int diametr, double distanceFromSun) {
		this.diametr = diametr;
		this.distanceFromSun = distanceFromSun;
	}

	public void printDiametr() {
		System.out.println(diametr);
	}

	public void printDistanceFromSun() {
		System.out.println(distanceFromSun);
	}

	@Override
	void printMessage() {
		System.out.println("Hello from planet");

	}

	/*
	 * (Дополнительное домашнее задание: Переопределить методы hashCode() и
	 * toString() для каждого из классов. Продемонстрировать работу этих методов.
	 */
	
	public int hashCode() {
		return (int) (31 * diametr * distanceFromSun);
	}

	public String toString() {
		return getClass().getName() + "@" + "diametr: " + diametr + " distanceFromSun" + distanceFromSun;
	}
}
