package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Testing divisibility of numbers 
 * Date modified: 9/6/2019
 */

import java.util.Scanner; 

public class O05Divisibility {
	public static void main(String[] args) {

		int number; 
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Receive an input
		System.out.print("Enter an integer: ");
		number = input.nextInt();
		input.close();

		//Check number is divisible by some integers using if
		System.out.println ("-------------------------------------------");
		System.out.println ("Trying divisibility tests first time: Find the first factor");
		System.out.println ("-------------------------------------------");


		if (number % 2 == 0){
			System.out.println (number + " is " + "divisible by 2");
		}

		if (number % 3 == 0){
			System.out.println (number + " is " + "divisible by 3");
		}

		if (number % 4 == 0){
			System.out.println (number + " is " + "divisible by 4");
		}

		if (number % 5 == 0){
			System.out.println (number + " is " + "divisible by 5");
		}    

		else {
			System.out.println (number + " is not divisible by 2, 3, 4, or 5");
		}


	}
}