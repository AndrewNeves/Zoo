package main;

import java.util.Random;

import main.animals.*;
import main.environment.DayOrNight;

public class Zoo {
	
	public Tiger tiger;
	public SmallWhale smallWhale;
	public Goldfish goldfish;
	
	public Animal[] animals; 
	public IAirBreather[] airBreathers;
	public IWaterAnimal[] waterAnimals;
	
	private DayOrNight dayOrNight;
	
	Random rand;

	public Zoo() {
		
		rand = new Random(); 
		
		tiger = new Tiger(rand);
		smallWhale = new SmallWhale(rand);
		goldfish = new  Goldfish(rand);
		
		animals = new Animal[] { tiger, smallWhale, goldfish };
		airBreathers = new IAirBreather[] { tiger, smallWhale };
		waterAnimals = new IWaterAnimal[] { smallWhale, goldfish };
		
		dayOrNight = rand.nextInt(2) == 1 ? DayOrNight.Day : DayOrNight.Night;
	}

	
	public DayOrNight dayOrNight() {
		return dayOrNight;
	}	
}
