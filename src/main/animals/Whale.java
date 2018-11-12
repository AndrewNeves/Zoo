package main.animals;

import java.util.Random;

/**
 * Whale class
 */
public final class Whale extends Animal implements IWaterAnimal, IAirBreather {

	/**
     * @see Animal#Animal(boolean, SleepWakeState)
	 */
	public Whale(boolean isHungry, SleepWakeState sleepWakeState) {
		super(isHungry, sleepWakeState);
	}

	/**
     * @see Animal#Animal(Random)
	 */
	public Whale(Random rand) {
		super(rand);
	}
	
	@Override
	public boolean putToSleep() throws UnsupportedOperationException {
		return super.putToSleep();
	}
	
	@Override
	public boolean wakeUp() throws UnsupportedOperationException {
		return super.wakeUp();
	}
	
}
