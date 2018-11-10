package test.Animals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Animals.Animal;
import main.Animals.SmallWhale;

class SmallWhaleTest {

	@Test
	void testFeedWhenNotHungry() {
		SmallWhale smallWhale = new SmallWhale(false, Animal.SleepWakeState.Awake);
		boolean smallWhaleEats = smallWhale.feed();
		
		assertEquals(false, smallWhaleEats, "SmallWhale ate when not hungry.");
		assertEquals(false, smallWhale.isHungry(), "SmallWhale became hungry unexpectedly.");
	}

	@Test
	void testFeedWhenSleeping() {
		SmallWhale smallWhale = new SmallWhale(true, Animal.SleepWakeState.Sleeping);
		boolean smallWhaleEats = smallWhale.feed();
		
		assertEquals(false, smallWhaleEats, "SmallWhale ate when sleeping.");
		assertEquals(true, smallWhale.isHungry(), "SmallWhale became not hungry unexpectedly.");
	}
	
	@Test
	void testFeedWhenHungryAndAwake() {
		SmallWhale smallWhale = new SmallWhale(true, Animal.SleepWakeState.Awake);
		boolean smallWhaleEats = smallWhale.feed();

		assertEquals(true, smallWhaleEats, "SmallWhale did not eat when hungry and awake.");
		assertEquals(false, smallWhale.isHungry(), "SmallWhale is still hungry after eating.");
	}
	
	@Test
	void testGiveWater() {
		SmallWhale smallWhale = new SmallWhale(false, Animal.SleepWakeState.Awake);
		boolean smallWhaleDrinks = smallWhale.giveWater();
		
		assertEquals(false, smallWhaleDrinks, "SmallWhale drinks when not thirsty.");
		assertEquals(false, smallWhale.isThirsty(), "SmallWhale became thirsty unexpectedly.");
	}
	
	@Test
	void testPutToSleepWhenSleeping() {
		SmallWhale smallWhale = new SmallWhale(false, Animal.SleepWakeState.Sleeping);
		boolean smallWhaleGoesToSleep = smallWhale.putToSleep();

		assertEquals(false, smallWhaleGoesToSleep, "SmallWhale went to sleep when already sleeping.");
		assertEquals(Animal.SleepWakeState.Sleeping, smallWhale.sleepWakeState(), "SmallWhale woke up unexpectedly.");
	}
	
	@Test
	void testPutToSleepWhenAwake() {
		SmallWhale smallWhale = new SmallWhale(false, Animal.SleepWakeState.Awake);
		boolean smallWhaleGoesToSleep = smallWhale.putToSleep();

		assertEquals(true, smallWhaleGoesToSleep, "Put smallWhale to sleep failed.");
		assertEquals(Animal.SleepWakeState.Sleeping, smallWhale.sleepWakeState(), "SmallWhale failed to go to sleep.");
	}
	
	@Test
	void testWakeUpWhenAwake() {
		SmallWhale smallWhale = new SmallWhale(false, Animal.SleepWakeState.Awake);
		boolean smallWhaleWakesUp = smallWhale.wakeUp();

		assertEquals(false, smallWhaleWakesUp, "SmallWhale woke up when already awake.");
		assertEquals(Animal.SleepWakeState.Awake, smallWhale.sleepWakeState(), "SmallWhale went to sleep unexpectedly.");
	}
	
	@Test
	void testWakeUpWhenSleeping() {
		SmallWhale smallWhale = new SmallWhale(false, Animal.SleepWakeState.Sleeping);
		boolean smallWhaleWakesUp = smallWhale.wakeUp();

		assertEquals(true, smallWhaleWakesUp, "Wake up smallWhale failed.");
		assertEquals(Animal.SleepWakeState.Awake, smallWhale.sleepWakeState(), "SmallWhale failed to wake up.");
	}

}
