package main;

import java.util.Random;

import main.animals.*;
import main.animals.Animal.SleepWakeState;
import main.environment.DayOrNight;
import main.strings.ZooStrings;

/**
 * Class that contains the {@link main.animals.Animal Animals} in the zoo and
 * prints status reports about the {@link main.animals.Animal Animals} and zoo
 * conditions.
 */
public final class Zoo {

    private Tiger tiger;
    private Whale whale;
    private Goldfish goldfish;

    private Animal[] animals;

    private DayOrNight dayOrNight;

    private Random rand;

    /**
     * Zoo constructor. Initializes all the animals using their random constructors
     * and sets the day/night state randomly.
     * 
     * @see main.animals.Animal#Animal(Random)
     */
    public Zoo() {

        rand = new Random();

        tiger = new Tiger(rand);
        whale = new Whale(rand);
        goldfish = new Goldfish(rand);

        animals = new Animal[] { tiger, whale, goldfish };

        dayOrNight = rand.nextInt(2) == 1 ? DayOrNight.Day : DayOrNight.Night;
    }

    /** @return Day/Night status */
    public DayOrNight dayOrNight() {
        return dayOrNight;
    }

    /**
     * Randomly generated new states for the {@link main.animals.Animal Animals} and
     * randomly assigns a new day/night state.
     * 
     * @see main.animals.Animal#setNewRandomConditions(Random)
     */
    public void generateNewConditions() {
        for (int i = 0; i < animals.length; i++) {
            animals[i].setNewRandomConditions(rand);
        }

        dayOrNight = rand.nextInt(2) == 1 ? DayOrNight.Day : DayOrNight.Night;
    }

    /**
     * Returns the animal that corresponds with the animalName command line argument
     * string.
     * 
     * @param animalName An animal name command line argument string
     * @return The animal that matches the animalName.
     */
    public Animal getAnimal(String animalName) {
        Animal animal = null;

        switch (animalName) {
        case ZooStrings.TIGER_ARG:
            animal = tiger;
            break;
        case ZooStrings.WHALE_ARG:
            animal = whale;
            break;
        case ZooStrings.GOLDFISH_ARG:
            animal = goldfish;
            break;
        default:
            break;
        }

        return animal;
    }

    /**
     * Prints a report that says whether it is day or night and lists for each
     * {@link main.animals.Animal Animal} whether it is awake or sleeping, if it is
     * hungry or not and if it is thirsty or not.
     */
    public void printStatusReport() {
        System.out.println("\n|--------------------------------------------------|");
        if (dayOrNight() == DayOrNight.Day) {
            System.out.println("| DAYTIME ANIMAL STATUS REPORT                     |");
        } else {
            System.out.println("| NIGHTTIME ANIMAL STATUS REPORT                   |");
        }
        System.out.println("|==================================================|");

        for (Animal animal : animals) {
            printAnimalStatus(animal);
        }

        System.out.println("|==================================================|\n");
    }

    private void printAnimalStatus(Animal animal) {
        System.out.print("| ");
        String animalName = animal.getClass().getSimpleName();
        System.out.print(animalName);
        for (int i = 0; i < 11 - animalName.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("| ");
        System.out.print(animal.sleepWakeState() == SleepWakeState.Awake ? "Awake    | " : "Sleeping | ");
        System.out.print(animal.isHungry() ? "Hungry     | " : "Not hungry | ");
        System.out.print(animal.isThirsty() ? "Thirsty     |" : "Not thirsty |");
        System.out.println();
    }
}
