package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: A whole bunch of simple things we can do with numbers
 * Date modified: 10/1/2019
 */

import java.lang.Math;  //This importation is not necessary, it happens automatically
//https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
//http://www.cafeaulait.org/course/week4/40.html
//http://www.functionx.com/java/Lesson17.htm

public class O01Numbers1 {
	public static void main(String[] args) {


		int int1 = -8025;  //int is default for integers, int is 32 bit signed
		int int2 = 73;

		long long1 = -200000000L; //long is 64-bit signed, append L to
		//to an integer literal to say it's long

		float float1 = 2000.65F; //By default floating point literals are double, 
		// add F to say it's float

		//double numbers may end in D although the D is not necessary
		//double is default for decimals.  
		double double1 = -10000.25D;


		/*absolute value of a number
	     int     abs(int     value);
	     long    abs(long    value);
	     float   abs(float   value);
	     double  abs(double  value);
		 */

		System.out.println("Original int value = " + int1);
		System.out.println("Absolute value of " +  int1 +  " = " 
				+ Math.abs(int1) + "\n\n");

		System.out.println("Original int value = " + int2);
		System.out.println("Absolute value of " +  int2 + " = " 
				+ Math.abs(int2) + "\n\n");

		System.out.println("Original int value = " + long1);
		System.out.println("Absolute value of " +  long1 + " = " 
				+ Math.abs(long1) + "\n\n");

		System.out.println("Original Value = " + float1);
		System.out.println("Absolute Value = " + Math.abs(float1) + "\n\n");

		System.out.println("Original Value = " + double1);
		System.out.println("Absolute Value = " + Math.abs(double1) + "\n\n");	    
	}
}
