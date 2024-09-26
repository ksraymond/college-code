package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: A class that tests nested while loops.
 * Date modified: 9/17/2019
 */

public class O10NestedWhile {

	public static void main(String[] args) {
		int outer = 1;
		while (outer < 3) {
			System.out.println ("The outer loop iteration is outer = " + outer);		
			//inner loop: It will do all iterations before outer loop does another iteration	   
			int inner = 1;			
			while (inner <= 5) {
				System.out.println ("   The inner loop iteration is inner = " + inner);
				inner++;
			}	

			outer++;
		}
	}
}
