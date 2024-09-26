package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class converts a Fahrenheit temperature to Celsius
 * Date modified: 8/24/2019
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/* Pseudocode:
 * Input: fahrenheit temperature
 * Output: Temperature in celsius
 * 
 * Read fahrenheit from keyboard
 * celsius = 5.0/9 (fahrenheit - 32)
 * Print celsius to console
 */

public class O10Fahrenheit2Celsius{
	public static void main (String[] args){
		double fahrenheit, celsius; 

		Scanner keyboard = new Scanner (System.in);

		System.out.print("Enter a degree in Fahrenheit: ");
		fahrenheit = keyboard.nextDouble();
		//Note the .0 in the divide and - below
		celsius = (5.0/9) * (fahrenheit - 32.0);
		//Unicode characters: http://unicode-table.com/en
		//To see Unicode characters on screen, make sure Project --> Properties
		//--> Text file encoding is set to UTF-8
		System.out.println (fahrenheit + "\u00b0 F = " + 
				celsius + "\u00b0 C");
		keyboard.close();

		//formatting decimal output
		//https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
		DecimalFormat df = new DecimalFormat("000.##");
		System.out.println(df.format(celsius));
		System.out.println(df.format(fahrenheit) + "\u00b0 F = " + 
				df.format(celsius) + "\u00b0 C");			

		//more complex formatting
		//http://alvinalexander.com/programming/printf-format-cheat-sheet
		System.out.format("%6.2f%s%s%6.2f%s%s\n", 
				fahrenheit,  "\u00b0",  "F = ", celsius, 
				"\u00b0",  "C");  
				

	}
}
