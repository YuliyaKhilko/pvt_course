package core;

public class Task13 {

	public static void main(String[] args) {

		Planet planet = new Planet("Earth");
		
		try {
			planet.addAnimal("cat");
		} catch (InhabitedPlanetExcepton | NoFoodException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			planet.addPlant("grass");
		} catch (InhabitedPlanetExcepton e) {
			System.out.println(e.getMessage());
		}
		
		try {
			planet.setInhabited(true);
		} catch (NoWaterException e) {
			System.out.println(e.getMessage());
		} catch (InapropriateTemparatureException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			planet.addAnimal("cat");
		} catch (InhabitedPlanetExcepton | NoFoodException e) {
			System.out.println(e.getMessage());
		} finally {
			planet.killAnimals();
		}
	}

}
