package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints the area of a circle
 * Date modified: 8/24/2019
 */

/* Pseudocode (Need not be a part of the code, it should be written on paper before we code)
 * Input: radius
 * Output: area of the circle
 * 
 * area = pi * radius * radius
 * Print area
 */

public class O05Circle {

	public static void main (String [] args){
		double radius; //Declare radius, use a name that means something
		double area; // Declare area
		final double PI = 3.14159;

		//Assign a radius
		radius = 20.3; 
		
		//Compute area
		area = radius * radius * PI;

		//Display results
		System.out.println("Area of the circle with radius " + radius + " = " + area);
	}

}
