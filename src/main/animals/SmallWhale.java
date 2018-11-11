package main.animals;

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

	@Override
	public boolean putToSleep() throws UnsupportedOperationException {
		return super.putToSleep();
	}
	
	@Override
	public boolean wakeUp() throws UnsupportedOperationException {
		return super.wakeUp();
	}
	
}
