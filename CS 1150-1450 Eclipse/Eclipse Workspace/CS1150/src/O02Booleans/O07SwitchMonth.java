package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Read a month's number and print the month in String
 * Date modified: 9/6/2019
 */

import java.util.Scanner;

public class O07SwitchMonth {
	public static void main (String[] args) {

		Scanner keyboard = new Scanner (System.in);
		int month;
		String monthString;

		//Read a month
		System.out.println ("Type in the number for a month: ");
		month = keyboard.nextInt ();
		keyboard.close();

		//Print the appropriate month in letters

		switch (month) { //There is a break at the end of every case
		//The switch variable can be char, byte, short, int or String
		case 1:  monthString = "January";
		System.out.println (monthString + 
				": Have you made your resolutions?");
		break;
		case 2:  monthString = "February";
		System.out.println (monthString +
				": Have you found love yet?");
		break;
		case 3:  monthString = "March";
		System.out.println (monthString +
				": What are your Spring Break plans?");
		break;
		case 4:  monthString = "April";
		System.out.println (monthString + 
				": Time for taxes!");
		break;
		case 5:  monthString = "May";
		System.out.println (monthString +
				": Who is graduating?");
		break;
		case 6:  monthString = "June";
		System.out.println (monthString +
				": Finally, summer's here!");
		break;
		case 7:  monthString = "July";
		System.out.println (monthString + 
				": Independence Day fireworks at the park!");
		break;
		case 8:  monthString = "August";
		System.out.println (monthString + 
				": Dog days of summer!");
		break;
		case 9:  monthString = "September";
		System.out.println (monthString + 
				": Welcome the Freshmen!");
		break;
		case 10: monthString = "October";
		System.out.println (monthString + 
				": Are you going trick or treating?");
		break;
		case 11: monthString = "November";
		System.out.println (monthString +
				": I love Thanksgiving!");
		break;
		case 12: monthString = "December";
		System.out.println (monthString + 
				": Santa is coming to town!");
		break;
		default: monthString = "invalid month"; //Error case
		System.out.println (monthString + 
				": Do you know your months?");
		break; //not really necessary
		}

	}
}
