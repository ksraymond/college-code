package Homework3;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: to print the square roots of the first ten odd integers using a loop
 * Date modified: 10/20/2019
 */

/*Pseudocode:
 * import decimal format
 * int number
 * double result
 * while number < 20
 *  if number % 2 = 1
 *    result = math.sqrt(number)
 *    system.out.println(the square root of number is df.format(result))
 *  number++
 * 
 */

//importing decimal formatting
import java.text.DecimalFormat;

public class SqrtOdd {

	public static void main(String[] args) {

		//sets decimal format to always have two numbers after the decimal point
		DecimalFormat df = new DecimalFormat(".00");

		//initialize variables
		int number = 0;
		double result = 0;

		//while loop to test the first 20 numbers, the first 10 odd will be in this set
		while(number<20) {
			//if the number is odd, print the square root
			if(number % 2 == 1) {
				result = Math.sqrt(number);
				System.out.println("The square root of " + number + " is " + df.format(result));
			}
			//add one to the number to test the next number
			number++;
		}
	}
}