package Homework5;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: compute the area of different polygons using methods
 * Date modified: 11/17/2019
 */

/*Pseudocode:
 * variables:
 *	int n
 *	double s
 *	
 * main method:
 * ask for the user to input the number of sides and the side length
 * invoke method isValid
 * 	if true invoke method computeArea
 * 	if false print "Sorry your input is not valid. Bye." and System.exit(1);
 * 
 * isValid method:
 * public static boolean isValid(double s, int n)
 * if n >= 5 and s > 0
 * 	return true
 * else
 * 	return false
 * 
 * computeArea method:
 * public static double computeArea(double s, int n)
 * double area
 * if n == 5
 * 	area = ((5*s*s) / (4 * Math.tan(Math.PI/5)))
 * 	System.out.println("The pentagon's area is " + area)
 * if n == 6
 * 	area = ((6*s*s) / (4 * Math.tan(Math.PI/6)))
 *  System.out.println("The hexagon's area is " + area)
 * else
 * 	area = ((n*s*s) / (4 * Math.tan(Math.PI/n)))
 *  System.out.println("The " + n "gon's area is " + area)
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Polygons {

	public static void main(String args[]) {

		DecimalFormat df = new DecimalFormat(".00"); //format output with 2 decimal places
		
		//asking for the two inputs, side length and number of sides
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter s (the length of a side) and n (the number of sides):");
		double s = input.nextDouble();
		int n = input.nextInt();
		input.close();
		
		double area = computeArea(s,n);

		//if the inputs don't meet the parameters, exit
		if (isValid(s,n) == false) {
			System.out.println("Sorry your input is not valid. Bye.");
			System.exit(1);
		} //end if the inputs aren't valid

		//if the amount of sides is 5
		if(n == 5)
			System.out.println("The pentagon's area is " + df.format(area));

		//if the amount of sides is 6
		if(n == 6)
			System.out.println("The hexagon's area is " + df.format(area));

		//if the amount of sides is more than 6
		else
			System.out.println("The " + n + "-gon's area is " + df.format(area));

	} //end main method

	//method to test if the inputs meet the parameters
	public static boolean isValid(double s, int n) {
		if(n >= 5 && s > 0)
			return true;
		else
			return false;
	} //end isValid method

	//method to calculate the area
	public static double computeArea(double s, int n) {
		double area = ((n*s*s) / (4 * Math.tan(Math.PI/n)));
		return area;
	} //end computeArea method

} //end public class block