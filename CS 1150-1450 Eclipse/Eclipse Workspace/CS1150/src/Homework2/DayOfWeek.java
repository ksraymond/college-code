package Homework2;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: using a switch statement to determine the day of the week
 * Date modified: 10/2/2019
 */

/*Pseudocode:
 * import keyboard
 * initialize int day and string dayString
 * ask for a number from 0-6
 * switch statement for each input with 0 being sunday and 6 being saturday
 * if the number is not between 0-6, say it is not a valid day
 */

import java.util.Scanner;

public class DayOfWeek {
	public static void main(String[] args) {

		//initialize keyboard and variables
		Scanner input = new Scanner (System.in);
		int day;
		String dayString;

		//Read a day
		System.out.print ("Type in the number for a day of the week between 0-6: ");
		day = input.nextInt ();
		input.close();

		//the different cases for each different input
		switch (day) {
		case 0: dayString = "Sunday";
		System.out.println ("Today is: " + dayString);
		break;
		case 1: dayString = "Monday";
		System.out.println ("Today is: " + dayString);
		break;
		case 2: dayString = "Tuesday";
		System.out.println ("Today is: " + dayString);
		break;
		case 3: dayString = "Wednesday";
		System.out.println ("Today is: " + dayString);
		break;
		case 4: dayString = "Thursday";
		System.out.println ("Today is: " + dayString);
		break;
		case 5: dayString = "Friday";
		System.out.println ("Today is: " + dayString);
		break;
		case 6: dayString = "Saturday";
		System.out.println ("Today is: " + dayString);
		break;
		default:dayString = "invalid day";
		System.out.println (dayString + " Please make sure the number is between 0 and 6. Good bye!");
		}       
	}
}