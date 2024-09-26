package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Shows that a method can variable number of arguments
 * Date modified: 10/31/2019
 */

public class O08VarLengthArgs {

	//double... means any number of double arguments can be sent
	//numbers comes to the method as an array
	//We can have only one variable length argument, and it must be the last one
	public static double average(double... numbers ) {

		double total = 0.0; // initialize total
		// calculate total using the enhanced for statement
		for (double d : numbers )              
			total = d + total;                          

		return total / numbers.length;
	} // end method average

	public static void main(String args[] ){
		double d1 = 10.0, d2 = 20.0, d3 = 30.0, d4 = 40.0;

		System.out.printf("d1 = %.1f\nd2 = %.1f\nd3 = %.1f\nd4 = %.1f\n\n",
				d1, d2, d3, d4 );

		//calls with various numbers of arguments to method average
		System.out.printf( "Average of d1 and d2 is %.1f\n", 
				average(d1, d2) ); 
		System.out.printf( "Average of d1, d2 and d3 is %.1f\n", 
				average(d1, d2, d3) );
		System.out.printf( "Average of d1, d2, d3 and d4 is %.1f\n", 
				average(d1, d2, d3, d4) );
	} // end main


}
