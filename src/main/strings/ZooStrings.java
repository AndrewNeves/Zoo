package main.strings;

public final class ZooStrings {
	
	public static final String FEED_CMD = "feed";
	public static final String GIVE_WATER_CMD = "water";
	public static final String PUT_TO_SLEEP_CMD = "sleep";
	public static final String WAKE_UP_CMD = "wake";
	public static final String REPORT_CMD = "report";
	public static final String NEW_CMD = "new";
	public static final String EXIT_CMD = "exit";
	public static final String QUIT_CMD = "quit";
	public static final String TIGER_ARG = "tiger";
	public static final String WHALE_ARG = "whale";
	public static final String GOLDFISH_ARG = "goldfish";
	
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
