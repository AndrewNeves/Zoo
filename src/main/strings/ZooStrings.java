package main.strings;

/**
 * This class contains command line interface string constants and {@link main.Zoo Zoo} related
 * string array parsing methods.
 */
public final class ZooStrings {
	
	/** Command line interface command for feeding hungry, awake {@link main.animals.Animal Animals}. */
	public static final String FEED_CMD = "feed";
	/** Command line interface command for giving water to thirsty {@link main.animals.Animal Animals}. */
	public static final String GIVE_WATER_CMD = "water";
	/** Command line interface command for putting awake {@link main.animals.IAirBreather IAirBreathers} to sleep at night. */
	public static final String PUT_TO_SLEEP_CMD = "sleep";
	/** Command line interface command for waking up sleeping {@link main.animals.IAirBreather IAirBreathers} during the day. */
	public static final String WAKE_UP_CMD = "wake";
	/** Command line interface command for generating a new animal status report. */
	public static final String REPORT_CMD = "report";
	/** 
	 * Command line interface command for generating new {@link main.animals.Animal Animal} and 
	 * {@link main.Zoo Zoo} conditions. 
	 */
	public static final String NEW_CMD = "new";
	/** Command line interface command for exiting the application. */
	public static final String EXIT_CMD = "exit";
	/** Alternate command line interface command for exiting the application. */
	public static final String QUIT_CMD = "quit";
	/** Command line interface argument for {@link main.animals.Tiger Tiger} */
	public static final String TIGER_ARG = "tiger";
	/** Command line interface argument for {@link main.animals.Whale Whale} */
	public static final String WHALE_ARG = "whale";
	/** Command line interface argument for {@link main.animals.Goldfish Goldfish} */
	public static final String GOLDFISH_ARG = "goldfish";
	
	/**
	 * Checks if an array of strings contains a target string.
	 * 
	 * @param arr The string array to check in for the target string str.
	 * @param str The target string to try to find in the array arr.
	 * @return true if arr contains str.
	 */
	public static boolean arrayContains(String[] arr, String str) 
	{
		boolean result = false;
		for(String s : arr)
		{
			if(s == str) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Check a string array for strings that appear more than once.
	 * 
	 * @param arr The string array to check for duplicates in.
	 * @return true if arr contains any duplicate strings.
	 */
	public static boolean arrayContainsDuplicates(String[] arr) 
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i].equals(arr[j]))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Get a string array containing only the command line arguments from the
	 * command line input array containing the command and the arguments.
	 * 
	 * @param cmd The command line input array containing the command and arguments.
	 * @return A string array containing only the arguments from the cmd array.
	 */
	public static String[] getArgs(String[] cmd) 
	{
		String[] args;
		if(cmd.length < 2) {
			args = new String[0];
		}
		else {
			args = new String[cmd.length -1];
			System.arraycopy(cmd, 1, args, 0, cmd.length-1);
		}
		return args;
	}
	
	/**
	 * Checks a command line arguments array to see if all included arguments are valid.
	 * 
	 * @param args The command line arguments array.
	 * @return true if all arguments are valid.
	 */
	public static boolean areArgumentsValid(String[] args)
	{
		boolean allArgsValid = true;
		
		for(String arg : args)
		{
			if(arg.equals(TIGER_ARG) ||
			   arg.equals(WHALE_ARG) ||
			   arg.equals(GOLDFISH_ARG))
			{
				continue;
			}
			else {
				allArgsValid = false;
				break;
			}
		}
		return allArgsValid;
	}
}
