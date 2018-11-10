package test.Animals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Animals.Goldfish;
import main.Animals.Animal;

class GoldfishTest {

	@Test
	void testFeedWhenNotHungry() {
		Goldfish goldfish = new Goldfish(false, Animal.SleepWakeState.Awake);
		boolean goldfishEats = goldfish.feed();
		
		assertEquals(false, goldfishEats, "Goldfish ate when not hungry.");
		assertEquals(false, goldfish.isHungry(), "Goldfish became hungry unexpectedly.");
	}

	@Test
	void testFeedWhenSleeping() {
		Goldfish goldfish = new Goldfish(true, Animal.SleepWakeState.Sleeping);
		boolean goldfishEats = goldfish.feed();
		
		assertEquals(false, goldfishEats, "Goldfish ate when sleeping.");
		assertEquals(true, goldfish.isHungry(), "Goldfish became not hungry unexpectedly.");
	}
	
	@Test
	void testFeedWhenHungryAndAwake() {
		Goldfish goldfish = new Goldfish(true, Animal.SleepWakeState.Awake);
		boolean goldfishEats = goldfish.feed();

		assertEquals(true, goldfishEats, "Goldfish did not eat when hungry and awake.");
		assertEquals(false, goldfish.isHungry(), "Goldfish is still hungry after eating.");
	}
	
	@Test
	void testGiveWater() {
		Goldfish goldfish = new Goldfish(false, Animal.SleepWakeState.Awake);
		boolean goldfishDrinks = goldfish.giveWater();
		
		assertEquals(false, goldfishDrinks, "Goldfish drinks when not thirsty.");
		assertEquals(false, goldfish.isThirsty(), "Goldfish became thirsty unexpectedly.");
	}
}
