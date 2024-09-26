package Homework2;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: to calculate the surface area of a sphere with radius r that must be > 0
 * Date modified: 10/2/2019
 */

/*Pseudocode:
 * import keyboard and decimal format
 * ask for number that will be the radius of sphere r
 * surface area - 4*PI*r*r
 * input must be greater than 0
 * if 0 or negative, print " “Please enter a positive number. Good bye!” and exit using System.exit(1);
 * print answer with 3 decimal points
 */

//importing keyboard and decimal formatting
import java.text.DecimalFormat;
import java.util.Scanner;

public class ValidateInput {

	public static void main(String[] args) {

		//initializing variables
		double radius;
		double area;
		final double PI = 3.14159;

		//asking for input
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the radius of the sphere: ");
		radius = input.nextDouble();
		input.close();

		//prints the surface area only if the input is more than 0
		if(radius > 0) {
			DecimalFormat df = new DecimalFormat(".000");
			area = (4 * PI * radius * radius);
			System.out.println("The surface area of the sphere is: " + df.format(area));
		}

		//if input is invalid, it exits
		else {
			System.out.println("Please enter a positive number. Good bye!");
			System.exit(1);
		}
	}

}

