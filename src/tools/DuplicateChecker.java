package tools;

import entities.animal_entities.Animal;
import entities.plant_entities.Plant;

import java.util.List;

public class DuplicateChecker {

    private List<Animal> animals;
    private List<Plant> plants;

    public DuplicateChecker(List<Animal> animals, List<Plant> plants) {
        setAnimals(animals);
        setPlants(plants);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public boolean plantNameAlreadyInList(String name) {
        for (Plant plant : plants) {
            if (plant.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean animalNameAlreadyInList(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) return true;
        }
        return false;
    }

}
