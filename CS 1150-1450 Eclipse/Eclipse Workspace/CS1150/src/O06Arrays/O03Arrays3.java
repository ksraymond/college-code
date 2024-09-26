package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Arrays3 that declares an integer array, stores elements in it
 * 			and prints them
 * Date modified: 10/31/2019
 */

class O03Arrays3 {
	public static void main(String[] args) {
		// declares an array of integers
		// allocates memory for 10 integers, intializes values at declaration
		int[] anArray= {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		int i; 

		System.out.println ("The array has " + anArray.length + " elements.\n");

		//print the elements of the array
		for (i = 0; i < anArray.length; i++){
			System.out.println ("Element at index " + i + ": " + anArray [i]);       	
		}
	}
} 