package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Arrays4 that declares an integer array, stores elements in it,
 * 			prints the elements, sums the elements and finds the max value in the array
 * Date modified: 10/31/2019
 */

class O04Arrays4 {
	public static void main(String[] args) {
		// declares an array of integers
		// allocates memory for 10 integers, intializes the array
		//if we initialize an array, it must be done together with its declaration
		int[] anArray = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		int i, total, max; 

		System.out.println ("The array has " + anArray.length + " elements.\n");

		//print the array elements using a for loop
		for (i = 0; i < anArray.length; i++){
			System.out.println ("Element at index " + i + ": " + anArray[i]);      	
		}

		// Summing all elements using a for loop 
		total = 0; //to sum, initialize the total to 0
		for (i = 0; i < anArray.length; i++) {
			total = total + anArray[i];
		}
		System.out.println("\nSum of the array elements is " + total);

		// Finding the largest element using a for loop
		max = anArray[0]; //initialize the max to the first element of the array
		int index = 0;
		for (i = 1; i < anArray.length; i++) {
			if (anArray[i] > max) {
				max = anArray[i];
				index = i;
			}
		}
		System.out.println("\nThe maximum element of the array is " + max + 
				" at index " + index);


	}
} 