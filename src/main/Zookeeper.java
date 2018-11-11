package main;

import java.util.Scanner;

import main.io.IOManager;

public class Zookeeper {
	
	private static Zoo zoo;
	
	public static void main(String[] args) {
		
		zoo = new Zoo();
		IOManager.printWelcomeMessage();
		IOManager.printZooStatusReport(zoo);

		Scanner scanner = null;
		String input;
		
		try 
		{
		    scanner = new Scanner(System.in);
		    
			while(true)
			{
				System.out.print("cmd> ");
				input = scanner.nextLine();
				System.out.println("Echo: " + input + "\n");
			}
		}
		finally 
		{
			System.out.println("Closing!");
		    if(scanner!=null)
		    {
		        scanner.close();
		    }
		}
	}
}
