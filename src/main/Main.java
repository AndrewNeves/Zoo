package main;

import java.util.Scanner;

import main.strings.ZooStrings;

/**
 * Class containing main() entry method which contains main loop.
 */
public class Main {

	private static Zoo zoo;
	private static Zookeeper zookeeper;
	
	/**
	 * Main application entry method. Creates the {@link main.Zoo Zoo} and {@link main.Zookeeper Zookeeper}.
	 * Gets input from the command line and passes it to the zookeeper from processing. Exits when the input
	 * is {@value main.strings.ZooStrings#EXIT_CMD} or {@value main.strings.ZooStrings#QUIT_CMD}.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) 
	{	
		zoo = new Zoo();
		zookeeper = new Zookeeper(zoo);
		
		printWelcomeMessage();
		zoo.printStatusReport();

		Scanner scanner = null;
		String input;
		
		try 
		{
		    scanner = new Scanner(System.in);
		    
			do
			{
				System.out.print("cmd> ");
				input = scanner.nextLine();
				zookeeper.processCommand(input);				
			}
		    while(!input.trim().toLowerCase().equals(ZooStrings.EXIT_CMD) && 
		    	  !input.trim().toLowerCase().equals(ZooStrings.QUIT_CMD));
		}
		finally 
		{
			System.out.print("\nGoodbye!\n");
		    if(scanner!=null)
		    {
		        scanner.close();
		    }
		}
	}
	
	private static void printWelcomeMessage() {
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
		    "   wake  [<animal(s)>]    Wake up a sleeping air breathers at any time.\n" +
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
}
