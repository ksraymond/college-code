package Homework4;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: to ask the user for the side length of a pentagon and only calculate the area if the value is positive
 * Date modified: 11/3/2019
 */

/*Pseudocode:
 * import decimal format and keyboard
 * variables:
 *    double side and area
 * tell user to input the side length of a pentagon
 * if the input is greater than 0
 * 	calculate the area of the pentagon
 * 	area = ((5 * side * side) / (4 * Math.tan(Math.PI / 5)))
 *  System.out.println("The area of the pentagon is " + area);
 * else
 * 	System.out.println("Please enter a positive number. Good bye!")
 * 	System.exit(1)
 */

//import keyboard and decimal format
import java.util.Scanner;
import java.text.DecimalFormat;

public class Pentagon {
	public static void main(String[] args) {
		
		//initialize variables
		double side, area;
		
		//asking for input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of a side of a pentagon: ");
		side = input.nextDouble();
		input.close();
		
		//if the input is positive, calculate the area and print
		if(side > 0) {
			DecimalFormat df = new DecimalFormat(".0");
			area = ((5 * side * side) / (4 * Math.tan(Math.PI / 5)));
			System.out.println("The area of the pentagon is " + df.format(area));
		}
		//if the input is 0 or negative, it exits the program
		else {
			System.out.println("Please enter a positive number. Good bye!");
			System.exit(1);
		}
	}

}
