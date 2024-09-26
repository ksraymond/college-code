package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints the area of square after reading its length
 * Date modified: 8/24/2019
 */

import java.util.Scanner; //import code to enable reading from terminal

/* Pseudocode
 * Input: length of square
 * Output: Area 
 * 
 * Read length from keyboard
 * area = length^2
 * Print area
 */

public class O08ComputeArea1 {
	public static void main (String[] args){
		double length, area; 
		//Create a Scanner object
		Scanner keyboard;
		keyboard = new Scanner(System.in);

		//Prompt the user to enter a length 
		System.out.print ("Enter a number for length: ");
		length = keyboard.nextDouble(); 

		keyboard.close();
		//Compute area
		area = length * length;

		//Display result
		System.out.println ("The area of the square = " + area);

	}
}
