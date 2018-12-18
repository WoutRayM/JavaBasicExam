package forestbook_app;

import entities.animal_entities.Carnivore;
import entities.animal_entities.Herbivore;
import entities.animal_entities.Omnivore;
import entities.plant_entities.*;
import service.ForestNotebook;

import java.util.HashSet;
import java.util.Set;

public class ForestBookApp {

    public static void main(String[] args) {

        ForestNotebook myNotes = new ForestNotebook();

        Tree plantOne = new Tree("White Tree of Gondor", 250);
        plantOne.setLeafType(LeafType.ROUND);
        myNotes.addPlant(plantOne);

        Weed plantTwo = new Weed("Shire Special", 30);
        plantTwo.setArea(50);
        myNotes.addPlant(plantTwo);

        Flower plantThree = new Flower("Kingsfoil", 15);
        plantThree.setSmell(Scent.SWEET);
        myNotes.addPlant(plantThree);

        Bush plantFour = new Bush("Ivy Bush", 35);
        plantFour.setFruit("Ivy");
        plantFour.setLeafType(LeafType.HEART);
        myNotes.addPlant(plantFour);

        Tree plantFive = new Tree("Treebeard", 540);
        plantFive.setLeafType(LeafType.NEEDLE);
        myNotes.addPlant(plantFive);


        Set<Plant> plantSet = new HashSet<>();
        Flower dietFoodOne = new Flower("Tasty Rose", 45);
        dietFoodOne.setSmell(Scent.PINEAPPLE);
        plantSet.add(dietFoodOne);

        Bush dietFoodTwo = new Bush("Cranberry Bush", 35);
        dietFoodTwo.setLeafType(LeafType.HEART);
        dietFoodTwo.setFruit("Cranberry");
        plantSet.add(dietFoodTwo);

        Tree dietFoodThree = new Tree("Apple tree", 350);
        dietFoodThree.setLeafType(LeafType.ROUND);
        plantSet.add(dietFoodThree);


        Herbivore animalOne = new Herbivore("Frodo", 54, 102, 14);
        animalOne.setPlantDiet(plantSet);
        myNotes.addAnimal(animalOne);

        Herbivore animalTwo = new Herbivore("Meriadoc", 60, 112, 17);
        animalTwo.addPlantToDiet(dietFoodOne);
        animalTwo.addPlantToDiet(dietFoodTwo);
        myNotes.addAnimal(animalTwo);

        Herbivore animalThree = new Herbivore("Peregrin", 65, 114, 20);
        animalThree.setPlantDiet(plantSet);
        myNotes.addAnimal(animalThree);

        Carnivore animalFour = new Carnivore("Boromir", 90, 190, 35);
        animalFour.setMaxFoodSize(165);
        myNotes.addAnimal(animalFour);

        Carnivore animalFive = new Carnivore("Faramir", 85, 185, 32);
        animalFive.setMaxFoodSize(150);
        myNotes.addAnimal(animalFive);

        Carnivore animalSix = new Carnivore("Denethor", 75, 175, 25);
        animalSix.setMaxFoodSize(250);
        myNotes.addAnimal(animalSix);

        Omnivore animalSeven = new Omnivore("Gandalf", 77, 200, 30);
        animalSeven.setMaxFoodSize(360);
        animalSeven.addPlantToDiet(dietFoodThree);
        myNotes.addAnimal(animalSeven);

        Omnivore animalEight = new Omnivore("Saruman", 75, 190, 28);
        animalEight.setMaxFoodSize(450);
        animalEight.setPlantDiet(plantSet);
        myNotes.addAnimal(animalEight);

        Omnivore animalNine = new Omnivore("Radagast", 65, 175, 25);
        animalNine.setMaxFoodSize(25);
        animalNine.setPlantDiet(plantSet);
        myNotes.addAnimal(animalNine);

        myNotes.printNotebook();

        myNotes.printSpecificAnimalsList();

        myNotes.sortAnimalsByName();
        myNotes.sortPlantsByName();

        myNotes.printNotebook();

    }

}
