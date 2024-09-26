package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints the average of numbers read from keyboard
 * Date modified: 8/24/2019
 */

import java.util.Scanner; //To enable reading from terminal or keyboard. 
//What's read is also shows up on screen

/* Pseudocode: Need not be part of code, it should be written on paper before we code
 * Input: Four numbers
 * Output: Average of the four numbers
 * 
 * Read four numbers from keyboard
 * Compute average
 * Print average
 */

public class O07Average {
	public static void main (String[] args){
		double first, second, third, fourth, average; 

		//create a new Scanner object
		//Read for Scanner: 
		//http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
		//http://www.cs.utexas.edu/users/ndale/Scanner.html
		Scanner keyboard;
		keyboard = new Scanner(System.in);

		//Prompt the user to enter four numbers
		System.out.print ("Enter four numbers: ");
		first = keyboard.nextDouble();
		second = keyboard.nextDouble();
		third = keyboard.nextDouble();
		fourth = keyboard.nextDouble();

		keyboard.close(); //if we don't close it, Java says resource leak

		//Compute average
		average = (first + second + third + fourth)/4;

		//Display results
		System.out.println("Average = " + average);


	}

}
