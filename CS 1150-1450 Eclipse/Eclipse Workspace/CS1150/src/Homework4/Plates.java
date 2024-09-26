package Homework4;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: to generate a random license plate
 * Date modified: 11/3/2019
 */

/*Pseudocode:
 * import decimal format
 * variables:
 *    int number
 *    char letter1, letter2, letter3
 * 
 * generate 3 random upper case letters and 1 number from 0-999
 * print the random license plate number
 */

//import decimal format
import java.text.DecimalFormat;

public class Plates {
	public static void main(String[] args) {

		//initialize variables
		int number;
		char letter1, letter2, letter3;
		
		//setup decimal format to always show the space for 3 numbers
		DecimalFormat df = new DecimalFormat("000");

		//3 random letters and a random number from 0-999
		letter1 = (char)('A' + Math.random() * ('Z' - 'A' + 1));
		letter2 = (char)('A' + Math.random() * ('Z' - 'A' + 1));
		letter3 = (char)('A' + Math.random() * ('Z' - 'A' + 1));
		number = (int)(Math.random() * 1000);
		
		//print the random license plate
		System.out.println("Your license plate is: " + letter1 +
				letter2 + letter3 + "-" + df.format(number));
	}
}
