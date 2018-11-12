package test.animals;

import main.animals.Animal;

public class ExtendedAnimal extends Animal {

	public ExtendedAnimal(boolean isThirsty, boolean isHungry, SleepWakeState sleepWakeState)
			throws UnsupportedOperationException {
		super(isThirsty, isHungry, sleepWakeState);
	}

	@Override
    public boolean putToSleep() {
        return super.putToSleep();
    }
    
	@Override
    public boolean wakeUp() {
		return super.wakeUp();
    }
}
