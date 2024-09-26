package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Declaring and printing booleans 
 * Date modified: 9/6/2019
 */

import java.util.Scanner; //To enable reading from terminal or screen


public class O02Boolean2 {
	public static void main (String[] args){ 

		//Declare variables
		int i1, i2;
		Scanner keyboard; 

		System.out.print ("Type in two integers : ");
		keyboard = new Scanner (System.in);
		i1 = keyboard.nextInt ();
		i2 = keyboard.nextInt ();
		keyboard.close();

		//Perform Boolean operations and print results 
		//Entering different numbers will provide different prints
		if (i1 == i2){
			System.out.println (i1 + " is equal to " + i2);
		}

		if (i1 > i2) {
			System.out.println (i1 + " > " + i2);
		}


		if (i1 < i2) {
			System.out.println (i1 + " < " + i2);
		}

		if (i1 <= i2) {
			System.out.println (i1 + " <= " + i2);
		}

		if (i1 >= i2) {
			System.out.println (i1 + " >= " + i2);
		}

	}
}
