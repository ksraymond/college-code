package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Rectangle1 that prints the perimeter and area of a rectangle
 * Date modified: 8/24/2019
 */

/* Pseudocode: Need not be part of code, it should be written on paper before we code
 * Input: height, width
 * Output: perimeter and area of the rectangle
 * 
 * perimeter = 2 * (height + width)
 * area = height * width
 * Print area
 */

public class O06Rectangle {

	public static void main (String [] args){
		//Read for primitive data types: 
		//https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
		double height; //Declare height
		double width, perimeter, area; //We can declare several variables at the same time
		

		//Assign values
		height = 10.25; 
		width = 20.56;

		//Display input values 
		System.out.println("Height of the rectangle = " + height);
		System.out.println("Width of the rectangle = " + width);

		//Compute perimeter and area
		perimeter = 2 * (height + width);
		area = height * width;

		//Display results
		System.out.println("Perimeter of the rectangle = " + perimeter);
		System.out.println("Area of the rectangle = " + area);
	}
}
