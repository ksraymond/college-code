package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Demo pass-by-value: using swapping two numbers
 * 			as an example
 * Date modified: 10/17/2019
 */

public class O06Swap {

	public static void main(String[] args) {
		
		int number1 = 1;
		int number2 = 2;

		System.out.println("Before");
		System.out.println ("number1 = " + number1);
		System.out.println ("number2 = " + number2);

		swap(number1, number2);

		System.out.println("After");
		System.out.println ("number1 = " + number1);
		System.out.println ("number2 = " + number2);
	} // main

	public static void swap (int num1, int num2) {

		System.out.println("   *** Start Swap ***");
		System.out.println("   Before:  num1 = " + num1 + "  num2 = " + num2);

		// Swap the values
		int temp = num1;
		num1 = num2;
		num2 = temp;

		System.out.println("   After:   num1 = " + num1 + " num2 = " + num2);
		System.out.println("   *** End Swap ***");

	}
}
