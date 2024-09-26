package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Testing evenness of numbers 
 * Date modified: 9/6/2019
 */

import java.util.Scanner; 

public class O03Even1 {
	public static void main(String[] args) {

		int number; 
		// Create a Scanner
		Scanner keyboard = new Scanner(System.in);

		// Receive an input
		System.out.print("Enter an integer: ");
		number = keyboard.nextInt();
		keyboard.close();

		//Check number is even
		if (number % 2 == 0){
			System.out.println(number + " is even");
		}
		else {
			System.out.println (number + " is odd");
		}

		System.out.println ("Done with the number " + number);

	}
}