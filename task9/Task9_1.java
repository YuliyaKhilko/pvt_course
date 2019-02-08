package core;

public class Task9_1 {

	public static void main(String[] args) {
		// Один из классов на выбор должен содержать перегруженные связанные друг с
		// другом конструкторы (используя this) и создаваться с их помощью.
		Sun sun = new Sun(382.8);
		Sun sun2 = new Sun(500, 0.2);
		System.out.println(
				String.format("Sun: luminosity %s, energy production %s", sun.luminosity, sun.energyProduction));
		System.out.println(
				String.format("Sun2: luminosity %s, energy production %s", sun2.luminosity, sun2.energyProduction));

		// Другой - систему сеттеров и геттеров и инициализироваться при помощи их.
		Sirius sirius = new Sirius();
		sirius.setTemparature(25000);
		sirius.setDistanceFromEarth(8.6);
		System.out.println(String.format("Sirius: temperature %s C, distance from Earth %s light years",
				sirius.getTemparature(), sirius.getDistanceFromEarth()));

		// Третий - перегруженные, но не связанные друг с другом конструкторы и
		// создаваться при помощи одного из них на выбор.
		Mars mars = new Mars(6792, 228, 3396, 401);
		System.out.println(
				String.format("Mars: diameter %s, distance from Sun %s, core raduis %s, distance from Earth %s",
						mars.diametr, mars.distanceFromSun, mars.coreRadius, mars.distanceFromEarth));

		/*
		 * Сделать класс Звездная система абстрактным. Добавить к нему абстрактные
		 * методы (любые). Реализовать эти методы в классах-наследниках.
		 * Продемонстрировать работы этих методов для каждого из наследников.
		 */

		Planet planet = new Planet();
		planet.printMessage();

		Star star = new Star();
		star.printMessage();

		/*
		 * Дополнительное домашнее задание: Переопределить методы hashCode() и
		 * toString() для каждого из классов. Продемонстрировать работу этих методов.
		 */
		System.out.println(planet.hashCode() + " " + planet.toString());

	}

}
