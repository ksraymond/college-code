package O03Loops;

import java.util.Scanner;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Use do...while to implement the same code as 
 * 			O03SentinelValue
 * Date modified: 9/17/2019
 */

public class O04TestDoWhile {
	public static void main(String[] args) { 
		int data;
		int sum = 0;
		//int count = 0;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer (the input ends if it is 0): "); 

		// Keep reading data until the input is 0
		do {	
			// Read the next data 
			data = input.nextInt();
			sum += data;
			//if (data != 0) count++;
		} while (data != 0);

		input.close();
		System.out.println("The sum is " + sum);
		//System.out.println("The average is " + (double)sum/count);
	}
}
