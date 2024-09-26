package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: An example of overloading method max
 * Date modified: 10/17/2019
 */

public class O09OverloadingMax {
	public static void main(String[] args) {

		int maxValue = max (2, 5, 8); 
		System.out.println("The max of the three is: " + maxValue);
		System.out.println(max(8, 5));

	} // main

	// Note the 3 methods with the name max
	// The parameter lists are different for each method
	//    - max (int num1, int num2)
	//    - max (double num1, double num2)
	//    - max (int num1, int num2, int num3)
	// That means the method named max is "overload"

	public static int max (int num1, int num2) {
		System.out.println ("Method: Max of 2 integers");
		if (num1 > num2)
			return num1;
		else 
			return num2;
	}

	public static double max (double num1, double num2) {
		System.out.println ("Method: Max of 2 doubles");
		if (num1 > num2)
			return num1;
		else 
			return num2;
	}

	public static int max (int num1, int num2, int num3) {
		System.out.println ("Method: Max of 3 integers");
		return max(max (num1, num2), num3);
	}

}
