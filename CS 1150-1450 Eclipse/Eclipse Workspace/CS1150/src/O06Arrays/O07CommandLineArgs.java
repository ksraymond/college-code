package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Shows that a program can have "command line arguments", which can be passed to the 
 * 			main method. To provide command-line arguments in Eclipse, click "Run As"
 * 			and "Run Configurations..." and provide the command-line arguments as "Program Arguments"
 * 			separated by spaces.
 * 			Java programs can be run from the command-line in a Unix-like window. We haven't learned 
 * 			to do so yet. We are running with command line arguments using our IDE Eclipse now. 
 * Date modified: 10/31/2019
 */

public class O07CommandLineArgs {

	//One can send "command line arguments" to the main method
	public static void main (String[] mainArgs){
		System.out.println ("There are " + mainArgs.length 
				+ " command line arguments");

		//Command line arguments are given as an array of String named "mainArgs"
		for (String s: mainArgs){
			System.out.println (s);
		}
	}

}
