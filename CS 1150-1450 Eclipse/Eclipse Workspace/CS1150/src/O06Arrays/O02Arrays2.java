package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Arrays2 that declares an integer array, stores elements in it
 * 			and prints them
 * Date modified: 10/31/2019
 */

class O02Arrays2 {
	public static void main(String[] args) {
		// declares an array of integers
		int[] anArray;
		int i; 

		// allocates memory for 10 integers
		anArray = new int[10];

		// initialize first element
		anArray[0] = 100;
		// initialize second element
		anArray[1] = 200;
		// and so forth
		anArray[2] = 300;
		anArray[3] = 400;
		anArray[4] = 500;
		anArray[5] = 600;
		anArray[6] = 700;
		anArray[7] = 800;
		anArray[8] = 900;
		anArray[9] = 1000;

		//print the length of the array
		System.out.println ("The array has " + anArray.length + " elements.\n");

		//use a for loop to print elements of an array using an index i
		for (i = 0; i <= anArray.length-1; i++){
			System.out.println ("Element at index " + i + ": " + anArray [i]);        	
		}

	}
} 