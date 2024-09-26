package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Arrays1 that declares an integer array, stores elements in it
 * 			and prints them
 * Date modified: 10/31/2019
 */

class O01Arrays1 {
	public static void main(String[] args) {
		//Declares an array of integers; we can have arrays of other types.
		//Declaration allocates memory for a pointer/reference only, i.e., memory to 
		//store an address to the beginning of an array.
		//Declaration of an array doesn't allocate memory for elements on the array. 
		int[] anArray; 

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


		//printing out elements of the array starting index 0...9
		System.out.println("Element at index 0: " + anArray[0]);
		System.out.println("Element at index 1: " + anArray[1]);
		System.out.println("Element at index 2: " + anArray[2]);
		System.out.println("Element at index 3: " + anArray[3]);
		System.out.println("Element at index 4: " + anArray[4]);
		System.out.println("Element at index 5: " + anArray[5]);
		System.out.println("Element at index 6: " + anArray[6]);
		System.out.println("Element at index 7: " + anArray[7]);
		System.out.println("Element at index 8: " + anArray[8]);
		System.out.println("Element at index 9: " + anArray[9]);

	}
} 