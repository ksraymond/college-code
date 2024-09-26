package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Use a value-returning method to find the bigger
 * 			of the two integers
 * Date modified: 10/17/2019
 */

public class O01FindingMax{
	
	public static int max(int num1, int num2){
		int result;

		if (num1 >= num2)
			result = num1;
		else 
			result = num2;

		return result;
		
	}

	public static void main (String[] args){

		int i = 5;
		int j = 2;
		int k = max(i, j);

		System.out.println("The maximum between " + i + 
				" and " + j + " is: " + k);

	}

}
