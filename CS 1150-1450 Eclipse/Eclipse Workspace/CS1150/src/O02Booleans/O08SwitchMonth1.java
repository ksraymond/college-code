package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Read a month's number and print the month in String
 * Date modified: 9/6/2019
 */

import java.util.Scanner;

public class O08SwitchMonth1 {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		int month;
		String monthString;

		//Read a month
		System.out.println ("Type in the number for a month: ");
		month = input.nextInt ();
		input.close();

		//Print the appropriate month in letters
		switch (month) {
		case 1: monthString = "January";
		System.out.println (monthString + 
				": Have you made your resolutions?");
		case 2: monthString = "February";
		System.out.println (monthString +
				": Have you found love yet?");
		case 3: monthString = "March";
		System.out.println (monthString +
				": What are your Spring Break plans?");
		case 4: monthString = "April";
		System.out.println (monthString + 
				": Time for taxes!");
		case 5: monthString = "May";
		System.out.println (monthString +
				": Who is graduating?");
		case 6: monthString = "June";
		System.out.println (monthString +
				": Finally, summer's here!");
		case 7: monthString = "July";
		System.out.println (monthString + 
				": Independence Day fireworks at the park!");
		case 8: monthString = "August";
		System.out.println (monthString + 
				": Dog days of summer!");
		case 9: monthString = "September";
		System.out.println (monthString + 
				": Welcome the Freshmen!");
		case 10:monthString = "October";
		System.out.println (monthString + 
				": Are you going trick or treating?");
		case 11:monthString = "November";
		System.out.println (monthString +
				": I love Thanksgiving!");
		case 12:monthString = "December";
		System.out.println (monthString + 
				": Santa is coming to town!");
		default:monthString = "invalid month"; //Error case
		System.out.println (monthString + 
				": Do you know your months?");
		}       
	}
}
