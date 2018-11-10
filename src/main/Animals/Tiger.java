package main.Animals;

/**
 * Tiger class
 */
public final class Tiger extends Animal implements IAirBreather {

	/**
     * @see Animal#Animal(boolean, boolean, SleepWakeState)
	 */
	public Tiger(boolean isThirsty, boolean isHungry, SleepWakeState sleepWakeState) {
		super(isThirsty, isHungry, sleepWakeState);
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
