package O04NumStrings;

import java.util.Scanner; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Splits full name into first name, middle 
 * 			name (if exists)
 * Date modified: 10/1/2019
 */

public class O10SplitFullName {
	public static void main (String[] args){

		Scanner keyboard;
		keyboard = new Scanner (System.in);

		String fullName;
		System.out.println ("Please enter your full name: ");
		fullName = keyboard.nextLine(); 
		keyboard.close();
		System.out.println ("You entered: `" + fullName + "'");

		int firstBlankLocation; 
		firstBlankLocation = fullName.indexOf (' ');
		System.out.println ("First blank is located at: " + firstBlankLocation + " in the full name");

		String firstName;
		firstName = fullName.substring(0,firstBlankLocation);
		System.out.println ("First name: " + firstName);

		// use the following to find middle name if exists
		int secondBlankLocation;
		String middleName;
		fullName = fullName.substring(firstBlankLocation + 1);
		secondBlankLocation = fullName.indexOf(' ');
		middleName = fullName.substring(0, secondBlankLocation);
		System.out.println("Middle name: " + middleName);

	}

}
