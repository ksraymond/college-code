package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: More simple things we can do with numbers
 * Date modified: 10/1/2019
 */

import java.lang.Math; //This import is not necessary since it's automatic

public class O03Numbers3 {
	public static void main(String[] args) {
		int int1 = -8025;
		int int2 = 73;

		long long1 = 300000000l;
		long long2 = -2000000000L;

		//float floating point literals must end in f 
		float float1 = 1.25E4F;
		float float2 = 200.50F;

		//double numbers may end in D
		//double is default for decimals.  
		double double1 = -10000.25;
		double double2 = 200.50D;

		/* from documentation
	    int     min(int     val1, int     val2);
	    long    min(long    val1, long    val2);
	    float   min(float   val1, float   val2);
	    double  min(double  val1, double  val2);
		 */

		System.out.println("The minimum of " + int1 + " and " +
				int2 + " is " + Math.min(int1, int2));
		System.out.println("The minimum of " + long1 + " and " +
				long2 + " is " + Math.min(long1, long2));
		System.out.println("The minimum of " + float1 + " and " +
				float2 + " is " + Math.min(float1, float2));
		System.out.println("The minimum of " + double1 + " and " +
				double2 + " is " + Math.min(double1, double2) + "\n\n");

		//Here, we are mixing types; this is called implicit casting.
		//Not all implicit casting is allowed. 
		System.out.println("The minimum of " + int1 + " and " +
				double2 + " is " + Math.min(int1, double2));
		System.out.println("The minimum of " + long1 + " and " +
				int2 + " is " + Math.min(long1, int2));   

		//Maximum of two numbers
		System.out.println("The maximum of " + int1 + " and " +
				int2 + " is " + Math.max(int1, int2)); 
		System.out.println ("\n\n");

		//trigonometric functions
		System.out.println("The cosine of " + int2 + " radian is " + 
				Math.cos(int2));
		System.out.println("The sine of " + int2 + " radian is " + 
				Math.sin(int2));

	}
}

