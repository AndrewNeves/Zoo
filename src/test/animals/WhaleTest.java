package test.animals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.animals.Animal;
import main.animals.Whale;

class WhaleTest {

    @Test
    void testFeedWhenNotHungry() {
        Whale whale = new Whale(false, Animal.SleepWakeState.Awake);
        boolean whaleEats = whale.feed();

        assertEquals(false, whaleEats, "Whale ate when not hungry.");
        assertEquals(false, whale.isHungry(), "Whale became hungry unexpectedly.");
    }

    @Test
    void testFeedWhenSleeping() {
        Whale whale = new Whale(true, Animal.SleepWakeState.Sleeping);
        boolean whaleEats = whale.feed();

        assertEquals(false, whaleEats, "Whale ate when sleeping.");
        assertEquals(true, whale.isHungry(), "Whale became not hungry unexpectedly.");
    }

    @Test
    void testFeedWhenHungryAndAwake() {
        Whale whale = new Whale(true, Animal.SleepWakeState.Awake);
        boolean whaleEats = whale.feed();

        assertEquals(true, whaleEats, "Whale did not eat when hungry and awake.");
        assertEquals(false, whale.isHungry(), "Whale is still hungry after eating.");
    }

    @Test
    void testGiveWater() {
        Whale whale = new Whale(false, Animal.SleepWakeState.Awake);
        boolean whaleDrinks = whale.giveWater();

        assertEquals(false, whaleDrinks, "Whale drinks when not thirsty.");
        assertEquals(false, whale.isThirsty(), "Whale became thirsty unexpectedly.");
    }

    @Test
    void testPutToSleepWhenSleeping() {
        Whale whale = new Whale(false, Animal.SleepWakeState.Sleeping);
        boolean whaleGoesToSleep = whale.putToSleep();

        assertEquals(false, whaleGoesToSleep, "Whale went to sleep when already sleeping.");
        assertEquals(Animal.SleepWakeState.Sleeping, whale.sleepWakeState(), "Whale woke up unexpectedly.");
    }

    @Test
    void testPutToSleepWhenAwake() {
        Whale whale = new Whale(false, Animal.SleepWakeState.Awake);
        boolean whaleGoesToSleep = whale.putToSleep();

        assertEquals(true, whaleGoesToSleep, "Put whale to sleep failed.");
        assertEquals(Animal.SleepWakeState.Sleeping, whale.sleepWakeState(), "Whale failed to go to sleep.");
    }

    @Test
    void testWakeUpWhenAwake() {
        Whale whale = new Whale(false, Animal.SleepWakeState.Awake);
        boolean whaleWakesUp = whale.wakeUp();

        assertEquals(false, whaleWakesUp, "Whale woke up when already awake.");
        assertEquals(Animal.SleepWakeState.Awake, whale.sleepWakeState(), "Whale went to sleep unexpectedly.");
    }

    @Test
    void testWakeUpWhenSleeping() {
        Whale whale = new Whale(false, Animal.SleepWakeState.Sleeping);
        boolean whaleWakesUp = whale.wakeUp();

        assertEquals(true, whaleWakesUp, "Wake up whale failed.");
        assertEquals(Animal.SleepWakeState.Awake, whale.sleepWakeState(), "Whale failed to wake up.");
    }

}
