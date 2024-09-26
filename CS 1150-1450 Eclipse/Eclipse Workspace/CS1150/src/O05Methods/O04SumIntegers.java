package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Use a value-returning method to add integers 
 * 			from number1 to number2
 * Date modified: 10/17/2019
 */

import java.util.Scanner;

public class O04SumIntegers {

	//This method returns the sum of integers from i1 to i2
	public static int sum(int i1, int i2) {
		// Note: the method name is sum and we also declared a variable 
		// sum inside the method. This is legal in Java but could be 
		// confusing so renaming variable sum to something else, eg, result 

		int sum = 0;  //initialize the result to 0 every time before starting to add

		//add the integers as asked from i1 to i2 with a step of 1
		for (int i = i1; i <= i2; i++) {
			sum += i;
		}

		return sum;

		//System.out.println("Blahhhhhhhh");

	}


	//In the main method, we simply call the method sum()
	public static void main	(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt user for a positive integer value and store in the integer variables
		System.out.println("Enter two positive integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		input.close();

		//call method sum, which returns a integer, assign the value returned to totalSum
		int totalSum = sum(number1, number2);  // Value returned by sum is assigned to totalSum
		System.out.println ("Sum of numbers from " + number1 + 
				" to " + number2 + " is " + totalSum);
	} 

}
