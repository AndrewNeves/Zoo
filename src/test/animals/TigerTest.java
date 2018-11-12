package test.animals;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.animals.Animal;
import main.animals.Tiger;

class TigerTest {

    @Test
    void testFeedWhenNotHungry() {
        Tiger tiger = new Tiger(false, false, Animal.SleepWakeState.Awake);
        boolean tigerEats = tiger.feed();

        assertEquals(false, tigerEats, "Tiger ate when not hungry.");
        assertEquals(false, tiger.isHungry(), "Tiger became hungry unexpectedly.");
    }

    @Test
    void testFeedWhenSleeping() {
        Tiger tiger = new Tiger(false, true, Animal.SleepWakeState.Sleeping);
        boolean tigerEats = tiger.feed();

        assertEquals(false, tigerEats, "Tiger ate when sleeping.");
        assertEquals(true, tiger.isHungry(), "Tiger became not hungry unexpectedly.");
    }

    @Test
    void testFeedWhenHungryAndAwake() {
        Tiger tiger = new Tiger(false, true, Animal.SleepWakeState.Awake);
        boolean tigerEats = tiger.feed();

        assertEquals(true, tigerEats, "Tiger did not eat when hungry and awake.");
        assertEquals(false, tiger.isHungry(), "Tiger is still hungry after eating.");
    }

    @Test
    void testGiveWaterWhenNotThirsty() {
        Tiger tiger = new Tiger(false, false, Animal.SleepWakeState.Awake);
        boolean tigerDrinks = tiger.giveWater();

        assertEquals(false, tigerDrinks, "Tiger drinks when not thirsty.");
        assertEquals(false, tiger.isThirsty(), "Tiger became thirsty unexpectedly.");
    }

    @Test
    void testGiveWaterWhenAsleep() {
        Tiger tiger = new Tiger(true, false, Animal.SleepWakeState.Sleeping);
        boolean tigerDrinks = tiger.giveWater();

        assertEquals(false, tigerDrinks, "Tiger drinks when sleeping.");
        assertEquals(true, tiger.isThirsty(), "Tiger became not thirsty unexpectedly.");
    }

    @Test
    void testGiveWaterWhenThirstyAndAwake() {
        Tiger tiger = new Tiger(true, false, Animal.SleepWakeState.Awake);
        boolean tigerDrinks = tiger.giveWater();

        assertEquals(true, tigerDrinks, "Tiger did not drink when thirsty and awake.");
        assertEquals(false, tiger.isThirsty(), "Tiger is still thirsty after drinking.");
    }

    @Test
    void testPutToSleepWhenSleeping() {
        Tiger tiger = new Tiger(false, false, Animal.SleepWakeState.Sleeping);
        boolean tigerGoesToSleep = tiger.putToSleep();

        assertEquals(false, tigerGoesToSleep, "Tiger went to sleep when already sleeping.");
        assertEquals(Animal.SleepWakeState.Sleeping, tiger.sleepWakeState(), "Tiger woke up unexpectedly.");
    }

    @Test
    void testPutToSleepWhenAwake() {
        Tiger tiger = new Tiger(false, false, Animal.SleepWakeState.Awake);
        boolean tigerGoesToSleep = tiger.putToSleep();

        assertEquals(true, tigerGoesToSleep, "Put tiger to sleep failed.");
        assertEquals(Animal.SleepWakeState.Sleeping, tiger.sleepWakeState(), "Tiger failed to go to sleep.");
    }

    @Test
    void testWakeUpWhenAwake() {
        Tiger tiger = new Tiger(false, false, Animal.SleepWakeState.Awake);
        boolean tigerWakesUp = tiger.wakeUp();

        assertEquals(false, tigerWakesUp, "Tiger woke up when already awake.");
        assertEquals(Animal.SleepWakeState.Awake, tiger.sleepWakeState(), "Tiger went to sleep unexpectedly.");
    }

    @Test
    void testWakeUpWhenSleeping() {
        Tiger tiger = new Tiger(false, false, Animal.SleepWakeState.Sleeping);
        boolean tigerWakesUp = tiger.wakeUp();

        assertEquals(true, tigerWakesUp, "Wake up tiger failed.");
        assertEquals(Animal.SleepWakeState.Awake, tiger.sleepWakeState(), "Tiger failed to wake up.");
    }
}
