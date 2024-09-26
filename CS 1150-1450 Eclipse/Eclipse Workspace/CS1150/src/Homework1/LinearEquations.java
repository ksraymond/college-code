package Homework1;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: Solve a system of linear equations
 * Date modified: 9/18/2019
 */

public class LinearEquations {
	public static void main(String[] args) {

		//Declaring variables and assigning them values
		double a, b, c, d, x, y, e, f;
		a = 5.0;
		b = 3.0;
		c = 4.0;
		d = -6.0;
		e = 1.0;
		f = 2.0;
		x = ((e * d) - (b * f)) / ((a * d) - (b * c));
		y = ((a * f) - (e * c)) / ((a * d) - (b * c));
		e = (a * x) + (b * y);
		f = (c * x) + (d * y);

		//Printing the solutions to x and y
		System.out.print(" If 5x + 3y = 1 and 4x - 6y = 2 then" + 
				"\n" + "x = " + x + 
				"\n" + "and y = " + y);

	}

}