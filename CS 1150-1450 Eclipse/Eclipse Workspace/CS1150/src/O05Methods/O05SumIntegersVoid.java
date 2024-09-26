package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Use a void method to add integers 
 * 			from number1 to number2
 * Date modified: 10/17/2019
 */

import java.util.Scanner;

public class O05SumIntegersVoid {

	public static void printSum(int i1, int i2) {
		// Note: the method name is sum and we also declared a variable 
		// sum inside the method. This is legal in Java but could be 
		// confusing so renaming variable sum to something else, eg, result 
		int sum = 0;
		for (int i = i1; i <= i2; i++)
			sum += i;

		System.out.println ("Sum of numbers from " + i1 + 
				" to " + i2 + " is " + sum);

	}


	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);

		// Prompt user for a positive integer value and store in the integer variable N
		System.out.println("Enter two positive integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		input.close();

		//call method printSum, which returns nothing but prints the result
		printSum(number1, number2);
	}

}
