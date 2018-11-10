package main.Animals;

/**
 * Air breather animal interface.
 */
public interface IAirBreather {
	
	/** Public interface to {@link main.Animals.Animal#putToSleep() Animal.putToSleep()}. */
	boolean putToSleep();
	/** Public interface to {@link main.Animals.Animal#wakeUp() Animal.wakeUp()}. */
	boolean wakeUp();
	
}
