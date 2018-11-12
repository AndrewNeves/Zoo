package test.animals;

import java.util.Random;

import main.animals.Animal;
import main.animals.IWaterAnimal;

public class WaterAnimal extends Animal implements IWaterAnimal {

    public WaterAnimal(boolean isThirsty, boolean isHungry, SleepWakeState sleepWakeState)
            throws UnsupportedOperationException {
        super(isThirsty, isHungry, sleepWakeState);
    }

    public WaterAnimal(Random rand) {
        super(rand);
    }
}
