package O01Basics;

import java.util.Scanner;

/*
 * Pseudocode:
 * Input: the area of a circle
 * Output: its radius
 * 
 * Read in area from user
 * Calculate radius given that area
 * radius: square root of (area/PI)
 * print radius
 */

public class ComputeRadius {

	public static void main(String[] args) {
		
		double area, radius;		//declare variables
		final double PI = 3.14159;	//declare constants
		
		Scanner input = new Scanner(System.in);			//import scanner
		System.out.print("Please enter the area of a circle: ");
		area = input.nextDouble();		//tells user to input a number
		input.close();
		
		radius = Math.sqrt(area/PI);		//takes the square root of area/PI
		System.out.print("The radius is: " + radius);
	}
	
}
