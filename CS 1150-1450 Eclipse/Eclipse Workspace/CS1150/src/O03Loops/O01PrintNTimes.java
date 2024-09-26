package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints a sentence for many times
 * Date modified: 9/17/2019
 */

public class O01PrintNTimes {
	public static void main (String[] args){

		//declare a running counter for the loop
		int i;
		//declare a total number of times for the loop
		int times;

		//assign how many times
		times = 10;  //change times to 0, -20, 1000, etc. 

		//loop index must be initialized for a while loop 
		i=1; 	 
		//A very simple while loop 
		while (i <= times) {  //change to i >= times, i > times, etc. 
			System.out.println ("For the " + i + "th time: I didn't do my homework!");
			i=i+1;  //change it to i+2, i-1, i-2, etc. 
		}
		
		System.out.println ("\nThe value of i after the for loop: " + i + "\n" );	

	}
}
