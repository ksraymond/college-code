package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Another whole bunch of simple things we can do with numbers
 * Date modified: 10/1/2019
 */

import java.lang.Math; //provide built-in math methods and constants
import java.text.DecimalFormat;

public class O02Numbers2 {
	public static void main(String[] args) {
		int int1 = 5;
		int int2 = 73;

		//long integer literals must end in L or l; otherwise, the default integer literal
		//type is int
		long long1 = 300000000L; 

		//double numbers may end in d, but don't have to since double is the default for floating points
		//double is default for decimals.  
		double double1 = -10000.25;
		double double2 = 200.50D;

		//ceiling of a number 
		//double ceil(double a);
		System.out.println("The ceiling of " + double1 + " is " +
				Math.ceil(double1));
		System.out.println("The ceiling of " + double2 + " is " +
				Math.ceil(double2) + "\n\n");

		//double floor(double d);
		System.out.println("The floor of " + double2 + " is " +
				Math.floor(double2));
		System.out.println("The floor of " + int2 + " is " +
				Math.floor(int2) + "\n");

		//double pow(double x, double y);
		int result = (int) Math.pow(int1, 4);
		System.out.println("Pow(" + int1 + ", " + 4 + ") = " + result);
		System.out.println ("\n");

		//double sqrt(double d);
		System.out.println("The square root of " +
				long1 + " is " + Math.sqrt(long1));
		System.out.println ("\n");

	}
}

