package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Use a value-returning method to find the sign 
 * 			(+, - or 0) of an integer
 * Date modified: 10/17/2019
 */

public class O03FindingSign {
	public static void main (String[] args){

		System.out.println("The sign of 10 is " + sign(10));
		System.out.println("The sign of 0 is " + sign(0));
		System.out.println("The sign of -10 is " + sign(-10));
	}


	public static int sign(int n){
		if (n > 0)
			return 1;
		else if (n == 0)
			return 0;
		else //if (n < 0)
			return -1;
	}
}
