package main;

import java.util.Random;

import main.animals.*;
import main.animals.Animal.SleepWakeState;
import main.environment.DayOrNight;
import main.strings.ZooStrings;

public class Zoo {
	
	private Tiger tiger;
	private Whale whale;
	private Goldfish goldfish;
	
	private Animal[] animals; 
	
	private DayOrNight dayOrNight;
	
	private Random rand;

	public Zoo() {
		
		rand = new Random(); 
		
		tiger = new Tiger(rand);
		whale = new Whale(rand);
		goldfish = new  Goldfish(rand);
		
		animals = new Animal[] { tiger, whale, goldfish };
		
		dayOrNight = rand.nextInt(2) == 1 ? DayOrNight.Day : DayOrNight.Night;
	}
	
	public DayOrNight dayOrNight() {
		return dayOrNight;
	}
	
	public void generateNewConditions()
	{
		for(int i=0; i<animals.length; i++)
		{
			animals[i].setNewRandomConditions(rand);
		}
		
		dayOrNight = rand.nextInt(2) == 1 ? DayOrNight.Day : DayOrNight.Night;
	}
	
	public Animal getAnimal(String animalName)
	{
		Animal animal = null;
	
		switch(animalName)
		{
		case ZooStrings.TIGER_ARG:
			animal = tiger;
			break;
		case ZooStrings.WHALE_ARG:
			animal = whale;
			break;
		case ZooStrings.GOLDFISH_ARG:
			animal = goldfish;
			break;
		default:
			break;
		}
		
		return animal;
	}
	
	public void printWelcomeMessage() {
		System.out.print(
			"\n\n" +
			"Welcome to the zoo!\n" +
			"\n" +
		    "You are the zookeeper responsible for the well being of the animals in the zoo.\n" +
			"You can take care of the animals and keep track of them through this tool.\n" +
		    "\n" +
		    "Commands to take care of animals:\n" +
			"   feed  [<animal(s)>]    Feed hungry animal(s).\n" +
		    "   water [<animal(s)>]    Give water to thirsty animal(s).\n" +
			"   sleep [<animal(s)>]    Put an awake air breather to sleep at night.\n" +
		    "   wake  [<animal(s)>]    Wake up a sleeping air breather during the day.\n" +
			"\n" +
			"The [<animal(s)>] argument(s) can be a single animal or a space separated list of animals.\n" +
		    "Valid animals are: Tiger, Whale, Goldfish\n" +
			"\n" +
			"Commands to check on the animals:\n" +
			"   report     Print an animal status report.\n" +
			"\n" +
			"Command to generate new conditions:\n" +
		    "   new        Start a new shift with new randomly generated conditions.\n" +
			"\n" +
		    "To exit the application use command \"exit\" or \"quit\".\n" +
			"\n" +
		    "Here is your starting animal status report...\n"
		);
	}
	
	public void printStatusReport() {
		System.out.println("\n|--------------------------------------------------|");
		if(dayOrNight() == DayOrNight.Day)
		{
			System.out.println("| DAYTIME ANIMAL STATUS REPORT                     |");
		}
		else
		{
			System.out.println("| NIGHTTIME ANIMAL STATUS REPORT                   |");	
		}
		System.out.println("|==================================================|");
		
		for(Animal animal : animals)
		{
			printAnimalStatus(animal);
		}

		System.out.println("|==================================================|\n");
	}
	
	private void printAnimalStatus(Animal animal)
	{
		System.out.print("| ");
		String animalName = animal.getClass().getSimpleName();
		System.out.print(animalName);
		for(int i=0; i< 11-animalName.length(); i++)
		{
			System.out.print(" ");
		}
		System.out.print("| ");
		System.out.print(animal.sleepWakeState() == SleepWakeState.Awake ? "Awake    | " : "Sleeping | ");
		System.out.print(animal.isHungry() ? "Hungry     | " : "Not hungry | ");
		System.out.print(animal.isThirsty() ? "Thirsty     |" : "Not thirsty |");
		System.out.println();
	}
}
