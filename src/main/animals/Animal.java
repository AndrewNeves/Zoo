package main.animals;

import java.util.Random;

/**
 * This is the abstract animal base class from which all other animals are derived.
 */
public abstract class Animal {
	
	/** Awake/sleeping enumeration. */
	public static enum SleepWakeState
	{
		Sleeping,
		Awake
	}
	
	private boolean isThirsty;
	private boolean isHungry;
	private SleepWakeState sleepWakeState;
	
	/**
	 * Animal constructor accepting all fields for initialization.
	 * 
	 * @param isThirsty Sets whether or not animal is thirsty. This field must be set to false for 
     * {@link main.animals.IWaterAnimal IWaterAnimals}.
     * @param isHungry Sets whether or not animal is hungry.
     * @param sleepWakeState Sets whether animal is awake or asleep.
	 * @throws UnsupportedOperationException If attempting to initialize {@link main.animals.IWaterAnimal IWaterAnimal} 
	 * as thirsty.
	 */
    public Animal(boolean isThirsty, boolean isHungry, SleepWakeState sleepWakeState) throws UnsupportedOperationException {
		if(this instanceof IWaterAnimal && isThirsty)
		{
			throw new UnsupportedOperationException("Attempted to initialize IWaterAnimal as thirsty. "
					+ "IWaterAnimals cannot be thirsty.");
		}
		else
		{
			this.isThirsty = isThirsty;
			this.isHungry = isHungry;
			this.sleepWakeState = sleepWakeState;
		}
	}  
    
    /**
     * Animal constructor that initializes the animal's fields based on the output from a random number generator.
     * {@link main.animals.IWaterAnimal IWaterAnimals} are always initialized with isThirsty=false.
     * 
     * @param rand A random number generator
     * @throws IllegalArgumentException If rand is null.
     */
    public Animal(Random rand) throws IllegalArgumentException {
		if(rand == null) {
			throw new IllegalArgumentException();
		}
		else {
	    	if(this instanceof IWaterAnimal)
			{
				isThirsty = false;
			}
			else
			{
				this.isThirsty = rand.nextInt(2) == 1 ? true : false;
			}
			this.isHungry = rand.nextInt(2) == 1 ? true : false;
			this.sleepWakeState = rand.nextInt(2) == 1 ? SleepWakeState.Awake : SleepWakeState.Sleeping;	
		}
	}  
    
    /**
     * Animal constructor accepting only isHungry and sleepWakeState for initialization. isThirsty is Automatically
     * initialized to false. This constructor is meant to be called by {@link main.animals.IWaterAnimal IWaterAnimals}
     * which cannot be thirsty.
     * 
     * @param isHungry Sets whether or not animal is hungry.
     * @param sleepWakeState Sets whether animal is awake or asleep.
     */
    public Animal(boolean isHungry, SleepWakeState sleepWakeState) {
		this.isThirsty = false;
		this.isHungry = isHungry;
		this.sleepWakeState = sleepWakeState;
	}

    /** @return isThirsty */
	public boolean isThirsty() { return isThirsty; }
    /** @return isHungry */
	public boolean isHungry() { return isHungry; }
	/** @return sleepWakeState */
	public SleepWakeState sleepWakeState() { return sleepWakeState; }
	
	/**
	 * Feeding a hungry animal will make them not hungry. Feeding an animal that is not hungry will have no effect.
	 * 
	 * @return Status indicating if isHungry has been updated.
	 */
    public boolean feed()
    {
        boolean animalEatsTheFood = false;
        if(isHungry() && sleepWakeState() == SleepWakeState.Awake)
        {
            animalEatsTheFood = true;
            isHungry = false;
        }
        return animalEatsTheFood;
    }

    /**
     * Giving water to a thirsty animal will make them not thirsty. Giving water to an animal that is not thirsty 
     * will have no effect.
     * 
     * @return Status indicating if isThirsty has been updated.
     */
    public boolean giveWater()
    {
        boolean animalDrinksTheWater = false;
        if (isThirsty() && sleepWakeState() == SleepWakeState.Awake)
        {
            animalDrinksTheWater = true;
            isThirsty = false;
        }
        return animalDrinksTheWater;
    }
    
    /**
     * Putting an awake animal to sleep will change their sleepWakeState to Sleeping. Putting a sleeping
     * animal to sleep will have no effect.
     * 
     * @return Status indicating if sleepWakeState has been updated.
     * @throws UnsupportedOperationException If attempting to put a non-{@link main.animals.IAirBreather IAirBreather} 
     * to sleep.
     */
    protected boolean putToSleep() throws UnsupportedOperationException
    {
        if(this instanceof IAirBreather)
        {
            if(sleepWakeState == SleepWakeState.Awake)
            {
                sleepWakeState = SleepWakeState.Sleeping;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            throw new UnsupportedOperationException("Attempted to put a non-IAirBreather to sleep.");
        }
    }
    
    /**
     * Waking up a sleeping animal will change their sleepWakeState to Awake. Waking up an animal
     * that is already awake will have no effect.
     * 
     * @return Status indicating if sleepWakeState has been updated.
     * @throws UnsupportedOperationException If attempting to wake up a non-{@link main.animals.IAirBreather IAirBreather}.
     */
    protected boolean wakeUp() throws UnsupportedOperationException
    {
        if(this instanceof IAirBreather)
        {
            if(sleepWakeState == SleepWakeState.Sleeping)
            {
                sleepWakeState = SleepWakeState.Awake;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            throw new UnsupportedOperationException("Attempted to wake up a non-IAirBreather.");
        }
    }
    
    /**
     * Updates the animal's fields based on the output from a random number generator.
     * {@link main.animals.IWaterAnimal IWaterAnimals} isThirsty always set to false.
     * 
     * @param rand A random number generator
     * @throws IllegalArgumentException If rand is null.
     */
    public void setNewRandomConditions(Random rand) throws IllegalArgumentException {
		if(rand == null) {
			throw new IllegalArgumentException();
		}
		else {
	    	if(this instanceof IWaterAnimal)
			{
				isThirsty = false;
			}
			else
			{
				isThirsty = rand.nextInt(2) == 1 ? true : false;
			}
			isHungry = rand.nextInt(2) == 1 ? true : false;
			sleepWakeState = rand.nextInt(2) == 1 ? SleepWakeState.Awake : SleepWakeState.Sleeping;	
		}
	}
}
