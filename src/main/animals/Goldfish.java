package main.animals;

import java.util.Random;

/**
 * Goldfish class
 */
public final class Goldfish extends Animal implements IWaterAnimal {

    /**
     * @see Animal#Animal(boolean, SleepWakeState)
     */
    public Goldfish(boolean isHungry, SleepWakeState sleepWakeState) {
        super(isHungry, sleepWakeState);
    }

    /**
     * @see Animal#Animal(Random)
     */
    public Goldfish(Random rand) {
        super(rand);
    }

}
