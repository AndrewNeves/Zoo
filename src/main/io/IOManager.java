package main.io;

import main.Zoo;
import main.animals.Animal;
import main.animals.Animal.SleepWakeState;
import main.environment.DayOrNight;

public class IOManager {

	public static void printWelcomeMessage() {
		System.out.print(
			"\n\nWelcome to the zoo!\n\n" +
		    "You are the zookeeper responsible for the well being of the animals in the zoo.\n" +
			"You can take care of the animals and keep track of them through this tool.\n\n" +
		    "Commands to take care of animals:\n" +
			"   feed  [<animal(s)>]    Feed hungry animal(s).\n" +
		    "   water [<animal(s)>]    Give water to thirsty animal(s).\n" +
			"   sleep [<animal(s)>]    Put an awake AirBreather to sleep at night.\n" +
		    "   wake  [<animal(s)>]    Wake up a sleeping AirBreather during the day.\n\n" +
			"The [<animal(s)>] argument(s) can be a single animal or a space separated list of animals.\n" +
		    "Valid animals are: Tiger, SmallWhale, Goldfish, AirBreathers, WaterAnimals, Animals.\n\n" +
			"Commands to check on the animals:\n" +
			"   report     Print an animal status report.\n\n" +
			"Command to generate new conditions:\n" +
		    "   new        Start a new shift with new randomly generated conditions.\n\n" +
		    "Here is your starting animal status report...\n\n"
		);
	}
	
	public static void printZooStatusReport(Zoo zoo) {
		System.out.println("|--------------------------------------------------|");
		if(zoo.dayOrNight() == DayOrNight.Day)
		{
			System.out.println("| DAYTIME ANIMAL STATUS REPORT                     |");
		}
		else
		{
			System.out.println("| NIGHTTIME ANIMAL STATUS REPORT                   |");	
		}
		System.out.println("|==================================================|");
		
		for(int i=0; i<zoo.animals.length; i++)
		{
			printAnimalStatus(zoo.animals[i]);
		}

		System.out.println("|==================================================|\n");
	}
	
	private static void printAnimalStatus(Animal animal)
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
