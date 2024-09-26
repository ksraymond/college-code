package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class perimeter and area of a circle after reading its radius
 * Date modified: 8/24/2019
 */

import java.util.Scanner; //enable reading input from terminal

/* Pseudocode:
 * Input: radius
 * Output: Perimeter and area of circle
 * 
 * Read radius from keyboard
 * perimeter = 2 * pi * radius
 * area = pi * radius^2
 * Print perimeter and area to screen
 */

public class O09ComputeArea2 {
	public static void main (String[] args){
		double radius, perimeter, area; 
		//Declare a constant, its value must be given at declaration and cannot change later
		final double PI = 3.14159; 
		//Create a Scanner object
		Scanner keyboard = new Scanner (System.in);

		//Prompt the user to enter radius3
		System.out.print ("Enter your circle's radius: ");

		radius = keyboard.nextDouble();
		keyboard.close();

		//Compute perimeter and area
		perimeter = 2 * PI * radius; 
		area = PI * radius * radius;

		//Display answers
		System.out.println("Radius = " + radius);
		System.out.println("Perimeter = " + perimeter + "\n" + 
				"Area = " + area);

	}
}
