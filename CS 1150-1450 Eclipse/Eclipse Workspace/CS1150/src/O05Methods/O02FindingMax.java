package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Use a void method to find the bigger
 * 			of the two integers
 * Date modified: 10/17/2019
 */

public class O02FindingMax {

	public static void main (String[] args){

		int i = 5;
		int j = 2;
		max(i, j);

	}


	public static void max(int num1, int num2){
		int result;

		if (num1 >= num2)
			result = num1;
		else 
			result = num2;

		System.out.println("The maximum between " + num1 + 
				" and " + num2 + " is: " + result);
	}

}
