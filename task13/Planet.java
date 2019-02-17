package core;

import java.util.ArrayList;
import java.util.List;

public class Planet {

	private String planetName;
	private boolean isInhabited;
	private List<String> animals = new ArrayList<String>();
	private List<String> plants = new ArrayList<String>();
	private int averageTemperature;
	private boolean hasWater;

	public Planet(String planetName) {
		this.planetName = planetName;
	}

	boolean isInhabited() {
		return isInhabited;
	}

	void setInhabited(boolean isInhabited) throws NoWaterException, InapropriateTemparatureException {
		if (isInhabited) {
			if (!hasWater) {
				throw new NoWaterException();
			}
			if (averageTemperature < -50 && averageTemperature > 50) {
				throw new InapropriateTemparatureException();
			}
		}
		this.isInhabited = isInhabited;
	}

	public void addAnimal(String animal) throws InhabitedPlanetExcepton, NoFoodException {
		if (!isInhabited) {
			throw new InhabitedPlanetExcepton();
		}
		if (plants.size() == 0) {
			throw new NoFoodException();
		}
		animals.add(animal);
	}

	public void addPlant(String plant) throws InhabitedPlanetExcepton {
		if (!isInhabited) {
			throw new InhabitedPlanetExcepton();
		}
		plants.add(plant);
	}

	int getAverageTemperature() {
		return averageTemperature;
	}

	void setAverageTemperature(int averageTemperature) {
		this.averageTemperature = averageTemperature;
	}

	boolean isHasWater() {
		return hasWater;
	}

	void setHasWater(boolean hasWater) {
		this.hasWater = hasWater;
	}

	public void killAnimals() {
		animals.clear();
	}

}
