package Homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: To calculate the surface area of a sphere with radius r
 * Date modified: 9/18/2019
 */

/* Pseudocode:
 * ask for a floating point number which will be the radius
 * print the surface of a sphere with that input as its radius with only 2 decimal points
 * surface area = 4 * PI * r * r
 */
public class SurfaceOfSphere {

	public static void main(String[] args) {
		
		//initializes variables
		float radius;
		double area;
		final double PI = 3.14159;
		
		//asks the radius
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the radius of the sphere: ");
		radius = input.nextFloat();
		input.close();
		
		//prints the surface area
		DecimalFormat df = new DecimalFormat(".00");
		area = (4 * PI * radius * radius);
		System.out.println("The surface area of the sphere is: " + df.format(area));
	}
}
