package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints a multiplication table
 * 			of integers 1 through 9
 * Date modified: 9/17/2019
 */

public class O12MultiplicationTable {

	/** Main method */
	public static void main(String[] args) {
		// Display the table heading
		System.out.println("           Multiplication Table");

		// Display the number title
		System.out.print("    ");
		for (int j = 1; j <= 9; j++)
		{System.out.print("   " + j);}

		System.out.println("\n-----------------------------------------");


		// Print table body
		for (int i = 1; i <= 9; i++) { //outer for loop
			System.out.print(i + " | ");

			for (int j = 1; j <= i; j++) {//inner for loop, print a row
				// Display the product and align properly
				System.out.printf("%4d", i * j);
			}//end inner for loop


			System.out.println();

		}//end outer for loop


	}//end main method

}//end class
