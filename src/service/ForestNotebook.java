package service;

import entities.animal_entities.Animal;
import entities.animal_entities.Carnivore;
import entities.animal_entities.Herbivore;
import entities.animal_entities.Omnivore;
import entities.plant_entities.Plant;
import tools.DuplicateChecker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ForestNotebook {

    private List<Carnivore> carnivores = new ArrayList<>();
    private List<Omnivore> omnivores = new ArrayList<>();
    private List<Herbivore> herbivores = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();
    private int plantCount;
    private int animalCount;

    public ForestNotebook() {
    }

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(List<Carnivore> carnivores) {
        this.carnivores = carnivores;
    }

    public List<Omnivore> getOmnivores() {
        return omnivores;
    }

    public void setOmnivores(List<Omnivore> omnivores) {
        this.omnivores = omnivores;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public int getPlantCount() {
        return plants.size();
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void addAnimal(Animal newAnimal) {
        DuplicateChecker duplicateChecker = new DuplicateChecker(animals, plants);
        if (!duplicateChecker.animalNameAlreadyInList(newAnimal.getName())) {
            animals.add(newAnimal);
            if (newAnimal instanceof Herbivore) {
                herbivores.add((Herbivore) newAnimal);
            } else if (newAnimal instanceof Carnivore) {
                carnivores.add((Carnivore) newAnimal);
            } else omnivores.add((Omnivore) newAnimal);
        } else System.out.println("You already have this animal in the list");
    }

    public void addPlant(Plant newPlant) {
        DuplicateChecker duplicateChecker = new DuplicateChecker(animals, plants);
        if (!duplicateChecker.plantNameAlreadyInList(newPlant.getName())) {
            plants.add(newPlant);
        } else System.out.println("You already have this plant in the list");
    }

    public void printNotebook() {
        if (getPlantCount() > 0) {
            System.out.println("Currently noted Plants: " + getPlantCount());
            plants.forEach(plant -> System.out.println("- " + plant.getName()));
        }
        if (getAnimalCount() > 0) {
            System.out.println("Currently noted Animals: " + getAnimalCount());
            animals.forEach(animal -> System.out.println("- " + animal.getName()));
        }
    }

    public void sortAnimalsByName() {
        this.animals = this.animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .collect(Collectors.toList());
    }

    public void sortAnimalsByHeight() {
        this.animals = this.animals.stream()
                .sorted(Comparator.comparing(Animal::getHeight))
                .collect(Collectors.toList());
    }

    public void sortPlantsByName() {
        this.plants = this.plants.stream()
                .sorted(Comparator.comparing(Plant::getName))
                .collect(Collectors.toList());
    }

    public void sortPlantsByHeight() {
        this.plants = this.plants.stream()
                .sorted(Comparator.comparing(Plant::getHeight))
                .collect(Collectors.toList());
    }

    public void printSpecificAnimalsList() {

        System.out.println("-------------");
        System.out.println("Ominvores: ");
        getOmnivores().forEach(omnivore -> System.out.println(omnivore.getName()));
        System.out.println();
        System.out.println("Carnivores: ");
        getCarnivores().forEach(carnivore -> System.out.println(carnivore.getName()));
        System.out.println();
        System.out.println("Herbivores: ");
        getHerbivores().forEach(herbivore -> System.out.println(herbivore.getName()));
        System.out.println("-------------");

    }
}
