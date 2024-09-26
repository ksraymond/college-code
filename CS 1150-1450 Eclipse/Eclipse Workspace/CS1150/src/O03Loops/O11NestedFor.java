package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: A class that tests nested for loops.
 * Date modified: 9/17/2019
 */

public class O11NestedFor {

	public static void main(String[] args) {
		for (int outer = 1; outer < 3; outer++) {
			System.out.println ("The outer loop iteration is outer = " + outer);

			// This is the inner for loop
			// It will do all iterations before outer loop does another iteration
			for (int inner = 1; inner <= 5; inner++) {
				System.out.println ("   The inner loop iteration is inner = " + inner);
			}

		}

	}

}
