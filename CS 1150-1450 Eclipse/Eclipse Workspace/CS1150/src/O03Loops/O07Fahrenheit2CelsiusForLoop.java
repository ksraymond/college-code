package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Farenheit2CelsiusForLoop that 
 * 			reads a starting degree, and increment and end degree
 * 			and uses a for loop to perform conversion from Fahrenheit to Celsius
 * Date modified: 9/17/2019
 */

import java.util.Scanner; //enable reading from terminal

public class O07Fahrenheit2CelsiusForLoop { 
	public static void main (String[] args){
		double fahrenheit, celsius; 
		double startF, incrementF, endF; 

		//Read start, increment and end Fahrenheit temperatures
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Enter start, increment and end "
				+ "Fahrenheit degrees to convert: ");
		startF = keyboard.nextDouble (); 
		incrementF = keyboard.nextDouble ();
		endF = keyboard.nextDouble (); 
		keyboard.close();

		//a loop to convert the Fahrenheit degrees
		for (fahrenheit = startF; fahrenheit <= endF; 
				fahrenheit = fahrenheit + incrementF)
		{
			celsius = 5.0 /9.0 * (fahrenheit - 32.0);
			//print the output
			System.out.format("%6.2f%s%6.2f%s\n", 
					fahrenheit,  " F = ", celsius, " C");

		} 

	}

}
