package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Circle that prints the perimeter 
 * 			and area of a circle given its radius
 * Date modified: 10/17/2019
 */

public class O08Circle {

	//This is the method called printDashes, it has one parameter: the 
	//number of dashes to print
	public static void printDashes (int length) {

		for (int i=1; i <=length; i++){
			System.out.print("-");
		}
		System.out.println (); 

	} 

	//Method that returns the perimeter
	public static double perimeter (double radius) {
		return 2 * Math.PI * radius;
	}


	//Method that returns the area
	public static double area (double radius) {
		return Math.PI * radius * radius;
	}


	//main method that calls the two helper/auxiliary methods
	public static void main (String [] args){
		double radius; //Declare radius

		//Assign a radius
		radius = 20.0; 

		//Display results by calling the two methods
		printDashes(60); 
		System.out.printf ("%s%5.2f%s%5.2f\n", "Perimeter of the circle with radius ",  
				radius, " = ",  perimeter(radius));
		printDashes(50); 
		System.out.printf ("%s%5.2f%s%5.2f\n", "Area of the circle with radius ", radius,
				" = ",  area(radius));
		
		System.out.println();
	}

}
