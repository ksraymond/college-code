package Homework2;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: 
 * Date modified: 10/2/2019
 */

/*Pseudocode:
 * import decimal format and keyboard
 * int flight and bags
 * double cost
 * tell user flights and costs and bag information
 * ask flight
 * different if statements for flights
 * if not 1, 2, or 3, tell the user it is invalid and exit
 * add flight cost to cost
 * repeat for bags
 * print total cost
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class AirReservation {
	public static void main(String[] args) {
		//initializing variables
		double flight = 0;
		double bags = 0;
		double cost = 0;
		DecimalFormat df = new DecimalFormat(".00");
		
		//stating the different costs
		System.out.print("Flight 1: Sydney, Australia, fare: $1750.00\n"
				+ "Flight 2: London, England, fare: $1300.00\n" + 
				"Flight 3: Frankfurt, Germany, fare: $1450.00\n" + 
				"The airline also allows from 0 up to 2 checked bags, with $20.00 per bag.\n\n");

		//asking user for inputs flight and bags
		Scanner input = new Scanner(System.in);
		System.out.println("Where would you like to travel to? Select option 1, 2, or 3: ");
		flight = input.nextDouble();
		System.out.println("How many bags do you want to check? ");
		bags = input.nextDouble();
		input.close();

		//if statements for the different flight costs and if the flight number is invalid it exits
		if(flight == 1) {
			cost = cost+1750;
		}
		else if(flight == 2) {
			cost = cost+1300;
		}
		else if(flight == 3) {
			cost = cost+1450;
		}
		else {
			System.out.println(flight + " is not a valid flight number.\nProgram can't deal with flight "
					+ flight + ". Good bye.");
			System.exit(1);
		}

		//if statements for different bag costs and if the bag number is invalid it exits
		if(bags == 0) {
			cost = cost+0;
		}
		else if(bags == 1) {
			cost = cost+20;
		}
		else if(bags == 2) {
			cost = cost+40;
		}
		else {
			System.out.println("You may only have 0 to 2 checked bags.\nProgram can't deal with "
					+ bags + " checked bags. Good bye.");
			System.exit(1);
		}

		//printing the total cost given the flight and number of bags checked
		System.out.println("Your flight's total cost is: $" + df.format(cost));
	}
}
