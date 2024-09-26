package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Perimeter that prints the 
 * 			perimeters of various geometric shapes
 * Date modified: 10/17/2019
 */

public class O10Perimeter {

	//Overloaded methods

	//Method that returns the perimeter of a square
	public static double perimeter (double side) {
		return 4 * side; //perimeter of a square is 4 * side
	}

	//Method that returns the perimeter of a rectangle
	public static double perimeter (double length, double width){
		double answer;
		answer = 2 * (length +  width); //perimeter of a rectangle is 2 * sum of sides

		return answer; 
	}

	//Method that returns the perimeter of a triangle
	public static double perimeter (double side1, double side2, double side3){
		return side1 + side2 + side3; //perimeter of a triangle is sum of sides
	}

	//Method that returns the perimeter of a circle
	public static double perimeter (char c, double r){

		double p; 
		if (c == 'c'){
			p = 2 * Math.PI * r; //perimeter of a circle is 2 * pi * r
		}
		else {
			p = 0; //need to return a value in all cases
		}

		return p;
	}

	//Method that computes the perimeter of an ellipse
	//perimeter = 2 * pi * sqrt (1/2 * (a^2 + b ^2))
	//This is an approximation. There are several other approximations also. 
	//We can extend it to work with other types of geometric constructs also. 
	public static double perimeter (char c, double major, double minor){
		if (c == 'e'){ //each case must return something
			return 2 * Math.PI * Math.sqrt(0.5 * (major * major + minor * minor));		  
		}
		else {
			return 0;
		}

	}

	//main method that calls the several helper/auxiliary methods
	public static void main (String [] args){
		double w, l; //Declare width and length for rectangle
		double s1, s2, s3; //Declare sides for triangle
		double r; //Declare radius for circle
		double a, b; //Declare major and minor semi-axes for ellipse
		char type; 

		double side = 3.0;
		perimeter(side);

		//Assign a value. Assume we are talking about a square
		l = 20.0; 
		System.out.printf ("%s%5.2f%s%5.2f\n", "Perimeter of the square with side ",  
				l, " = ",  perimeter(l));

		//Assign two values. Assume we are talking about a rectangle
		//Display results by calling the two methods
		l = 30.0; w = 20.0; 
		System.out.printf ("%s%5.2f%s%5.2f%s%5.2f\n", "Perimeter of the rectangle with length ", l, 
				" and width ", w, " = ",  perimeter(l, w));

		//Assign three values. Assume we are talking about a triangle
		//Display results by calling the two methods
		s1 = 30.0; s2 = 20.0; s3 = 10.0;
		System.out.printf ("%s%5.2f, %5.2f, and %5.2f%s%5.2f\n", 
				"Perimeter of the triangle with sides ", s1, s2, s3, 
				" = ",  perimeter(s1, s2, s3));

		//We are talking about a circle here
		r = 30.0;
		type = 'c'; //c stands for circle
		System.out.printf ("Perimeter of a circle with radius %6.2f = %6.2f\n", r, 
				perimeter (type, r));

		//We are talking about an ellipse here with major and minor axes
		a = 20.0; b = 30.0; 
		type = 'e'; //e stands for ellipse
		System.out.printf ("Perimeter of an ellipse with major axis %6.2f and minor axis %6.2f = %6.2f\n", 
				a, b, perimeter(type, a, b));

	}

}
