package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints various powers 
 * 			of integers between two limits: low and high
 * Date modified: 9/17/2019
 */

public class O05Powers {

	//A method to print the loop N, N^2, N^3 and 2^N
	//Here ^ means power
	public static void main (String[] args){

		int low, high; 
		int i; //for use in a loop
		String whatToPrint;

		//print the table headers
		System.out.println ("N\tN^2\tN^3\t2^N");
		System.out.println ("-------------------------------");

		//intialize limits
		low = 2; high = 20; 

		//print the powers as desired
		i = low;  //initialize loop variable
		while (i <= high){
			whatToPrint = i + "\t" + (long) (Math.pow (i, 2)) + "\t" +
					(long) (Math.pow (i, 3)) + "\t" +
					(long) (Math.pow (2, i)) + "\n";
			System.out.print (whatToPrint);
			i = i + 1;  //update the loop control/index variable
		}//while loop ends

	}//method ends

}//class ends
