package main.animals;

import java.util.Random;

/**
 * SmallWhale class
 */
public final class SmallWhale extends Animal implements IWaterAnimal, IAirBreather {

	/**
     * @see Animal#Animal(boolean, SleepWakeState)
	 */
	public SmallWhale(boolean isHungry, SleepWakeState sleepWakeState) {
		super(isHungry, sleepWakeState);
	}

	/**
     * @see Animal#Animal(Random)
	 */
	public SmallWhale(Random rand) {
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
