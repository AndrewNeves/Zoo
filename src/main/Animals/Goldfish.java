package main.Animals;

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

}
