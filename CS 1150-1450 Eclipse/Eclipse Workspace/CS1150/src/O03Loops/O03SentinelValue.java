package O03Loops;

import java.util.Scanner;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that calculates the sum of an 
 * 			unspecified number of integers, until 0 is entered
 * Date modified: 9/17/2019
 */

public class O03SentinelValue {
	public static void main(String[] args) { // Create a Scanner
		Scanner input = new Scanner(System.in);

		// Read an initial data
		System.out.print("Enter an integer (the input ends if it is 0): ");
		int data = input.nextInt();

		// Keep reading data until the input is 0
		int sum = 0;
		int count = 0;
		while (data != 0) {
			count++;
			sum += data;   // sum = sum + data;
			// Read the next data
			data = input.nextInt();
		}

		input.close();
		System.out.println("The sum is " + sum);
		System.out.println("The average is " + (double)sum/count);
		System.out.println(count);


	}
}
