package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Arrays5 that declares an integer array, stores elements in it,
 * 			prints the elements, sums the elements and finds the max value in the array.
 * 			It uses a different kind of for loop, called the "foreach" loop 
 * Date modified: 10/31/2019
 */

class O05Arrays5 {
	public static void main(String[] args) {
		// declares an array of integers
		// allocates memory for 10 integers
		int[] anArray = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		int total, max; 


		System.out.println ("The array has " + anArray.length + " elements.\n");

		//Print the array elements.
		//This is the "foreach" loop. The type must be given inside the parentheses
		for (int element: anArray){
			System.out.println ("Element at index " + element);      	
		}

		// Summing all elements
		total = 0;
		for (int element: anArray) {
			total = total + element;
		}
		System.out.println("\nThe sum of the elements in the array is " + total);

		// Finding the largest element
		max = anArray[0];
		for (int element: anArray) {
			if (element > max) {
				max = element;
			}
		}
		System.out.println("\nThe maximum element of the array is " + max);


	}
} 