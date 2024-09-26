package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that converts among basic data types
 * Date modified: 8/24/2019
 */


/* Look at 
 * http://way2java.com/casting-operations/data-type-casting-type-conversion/
 * for more details. You don't have to remember everything, but should get
 * a general feel for what's allowed and not allowed, and how things are done. 
 */

public class O11Casting {
	public static void main (String[] args){
		//Declare variables
		int i1, i2;
		double d;

		//assign values and print
		d = 100.5;
		System.out.println ("d = " + d);

		//cast or convert double to an int and print
		i1 = (int) d;
		System.out.println ("i1 = " + i1);

		//be careful of integer division
		i1=100; i2=7;
		System.out.println ("i2 = " + i2);
		System.out.println ("i1/i2 = " +  i1/i2);

		//This causes i1 to be cast into double first and then the division
		//takes place. 
		d = (double) i1 /i2; 
		System.out.println ("i1/i2 = " + d ); 

		//It actually casts 5 to double first before division
		System.out.println ((double) 5 / 2);
		

	}
}
