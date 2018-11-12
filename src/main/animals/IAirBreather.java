package main.animals;

/**
 * Air breather animal interface.
 */
public interface IAirBreather {
	
	/** Public interface to {@link main.animals.Animal#putToSleep() Animal.putToSleep()}. */
	boolean putToSleep();
	/** Public interface to {@link main.animals.Animal#wakeUp() Animal.wakeUp()}. */
	boolean wakeUp();
	
}
