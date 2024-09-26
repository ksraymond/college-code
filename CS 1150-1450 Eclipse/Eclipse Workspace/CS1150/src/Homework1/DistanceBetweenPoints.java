package Homework1;

//imports decimal format and keyboard
import java.text.DecimalFormat;
import java.util.Scanner;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: To find the distance between two points
 * Date modified: 9/18/2019
 */

/*Pseudocode:
 * have user input two points, (x1, y1) and (x2, y2)
 * x and y must be doubles
 * must print 3 decimal places in the solution
 * equation: sqrt((x1 - x2) (x1 - x2)) + ((y1 - y2) (y1 - y2))
 */

public class DistanceBetweenPoints {

	public static void main(String[] args) {

		//initializes variables
		double x1, x2, y1, y2, solution;

		Scanner input = new Scanner(System.in);

		//asking for the 4 values needed
		System.out.print("Enter the value of the first x coordinate: ");
		x1 = input.nextDouble();
		System.out.print("Enter the value of the first y coordinate: ");
		y1 = input.nextDouble();
		System.out.print("Enter the value of the second x coordinate: ");
		x2 = input.nextDouble();
		System.out.print("Enter the value of the second y coordinate: ");
		y2 = input.nextDouble();
		input.close();

		//prints the distance in the proper format
		DecimalFormat df = new DecimalFormat(".000");
		solution = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
		System.out.println("The Distance between the two points is " + df.format(solution));

	}

}
