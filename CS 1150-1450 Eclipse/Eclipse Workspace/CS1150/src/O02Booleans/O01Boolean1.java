package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Declaring and printing booleans 
 * Date modified: 9/6/2019
 */

import java.util.Scanner; //To enable reading from terminal or screen


public class O01Boolean1 {
	public static void main (String[] args){
		boolean testResult1, testResult2, testResult3, testResult4, testResult5; 

		//Declare variables
		int i1, i2;
		Scanner keyboard; 

		System.out.print ("Type in two integers : ");
		keyboard = new Scanner (System.in);
		i1 = keyboard.nextInt ();
		i2 = keyboard.nextInt ();
		keyboard.close();

		//Perform Boolean operations
		testResult1 = (i1 == i2); 
		testResult2 = (i1 > i2);
		testResult3 = (i1 < i2);
		testResult4 = (i1 <= i2);
		testResult5 = (i1 >= i2);

		//Print Boolean variables
		System.out.println ("Is " + i1 + " == " + i2 + "?: " +  testResult1);
		System.out.println ("Is " + i1 + " > " + i2 + "?: " + testResult2);
		System.out.println ("Is " + i1 + " < " + i2 + "?: " + testResult3);
		System.out.println ("Is " + i1 + " <=  " + i2 + "?: " + testResult4);
		System.out.println ("Is " + i1 + " >= " + i2 + "?: " + testResult5);


		//logical operator not
		System.out.println ("`not' " + testResult1 + " = " + (!testResult1));
		System.out.println ("`not' " + testResult2 + " = " + (!testResult2));


		//binary logical operators
		System.out.println (testResult1 + " and " +  testResult2 + " = "  +  (testResult1 && testResult2));
		System.out.println (testResult1 + " or " +  testResult2 + " = "  +  (testResult1 || testResult2));
		System.out.println (testResult1 + " `exclusive or' " +  
				testResult2 + " = "  +  (testResult1 ^ testResult2));

	}
}
