package test.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.animals.Animal.SleepWakeState;

public class AnimalExceptionsTest {

    @Test
    void testConstructThirstyWaterAnimal() {
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> new WaterAnimal(true, false, SleepWakeState.Awake));
    }

    @Test
    void testNullRandomConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WaterAnimal(null));
    }

    @Test
    void testPutToSleepNonAirBreather() {
        ExtendedAnimal eAnimal = new ExtendedAnimal(false, false, SleepWakeState.Awake);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> eAnimal.putToSleep());
    }

    @Test
    void testWakeUpNonAirBreather() {
        ExtendedAnimal eAnimal = new ExtendedAnimal(false, false, SleepWakeState.Sleeping);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> eAnimal.wakeUp());
    }
}