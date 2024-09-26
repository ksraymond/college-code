package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Declaring and printing strings 
 * Date modified: 10/1/2019
 * URLs of interest: 
 * 			http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * 			http://tutorials.jenkov.com/java/strings.html
 */

import java.util.Scanner; //To enable reading from terminal or screen

public class O07String1 {
	public static void main (String[] args){

		//Declare Scanner
		Scanner keyboard; 

		//Declare strings
		String welcomeString1, welcomeString2;
		String welcomeString3, welcomeString4;

		//Declare integer
		int stringLength; 

		//Assign values
		welcomeString1 = "Welcome to ";
		welcomeString2 = "UCCS, Freshmen Class of 2019!";

		//concatenate strings
		welcomeString3 = welcomeString1 + welcomeString2; 
		System.out.println (welcomeString3);

		//Length of a string
		stringLength = welcomeString3.length(); 
		System.out.println ("The length of welcomeString3 = " + stringLength);

		//Concatenating strings, another way
		welcomeString4 = welcomeString1.concat(welcomeString2);
		System.out.println (welcomeString4);

		//Other operations on strings
		System.out.println ("\'s\' occurs at index " + welcomeString2.indexOf('s') 
		+ " in '" + welcomeString2 + "'.");
		System.out.println ("The character at location 6 in '" 
				+ welcomeString2 + "' is '" + welcomeString2.charAt (6) 
				+ "'.");
		System.out.println ("If we uppercase '" + welcomeString2  
				+ "', we get '" + welcomeString2.toUpperCase() + "'.");
		System.out.println ("If we lowercase '" + welcomeString2  
				+ "', we get '" + welcomeString2.toLowerCase() + "'.");
		System.out.println ("If we replace C by X in '" + welcomeString2 
				+ "', we get '" + welcomeString2.replace ('C', 'X') 
				+ "',");


		//Reading a line from the terminal and printing it
		System.out.print ("\nType a string to read: ");
		keyboard = new Scanner(System.in); 
		welcomeString4 = keyboard.nextLine();
		keyboard.close();
		System.out.println ("You said: " + welcomeString4);
		
		// iterating a String using a loop

	}
}
