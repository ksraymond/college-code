package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class Arrays6 that declares an integer array, stores elements in it,
 * 			prints the elements, sums the elements and finds the max value in the array.
 * 			It uses a different kind of for loop, called the "foreach" loop 
 * 			It shows that we can pass an array as a parameter to a method. 
 * 			It also shows that a method can return an array to its caller. 
 * Date modified: 10/31/2019
 */

class O06Arrays6 {

	//A method can take an array as a formal parameter.
	//This method prints elements of an array. 
	//Remember arrays are passed to a method by address of 
	//of the first element or by reference to the array
	public static void printArray (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print (array[i] + " ");
		}
		System.out.println (); 
	}

	//This method has an int array as a formal parameter. 
	//It returns the sum of the array elements. 
	public static int addArray (int[] array) {
		int total = 0; 

		//sum the elements of the array using a "foreach" loop
		for (int element: array) {
			total = total + element; 
		}
		return total; 
	}

	//This method takes an int array as a formal parameter. 
	//It returns the maximum element of the array. 
	public static int maxArray (int[] array) {
		int max = array[0]; 

		//use a "foreach" loop to find the maximum element of the array
		for (int element: array) {
			if (element > max) {
				max = element;
			}
		}
		return max;
	}

	//A method can return an array also.
	//This method takes an array as a formal paramter. 
	//It also returns an array of int.
	//It uses two indices i and j to reverse the elements of an array
	public static int[] reverseArray (int[] array) {
		int[] result = new int[array.length];
		//can have two initializations, two updates 
		for (int i = 0, j = result.length - 1; i < array.length; i++, j--) {
			result[j] = array[i];
		}
		return result;
	}

	//A second way to write the reverseArray method
	public static int[] reverseArray1 (int[] array) {
		int[] result = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			result[result.length - (i+1)] = array[i];
		}
		return result;
	}

	//copying an array to a new array and returning the new array
	//This method takes an array as a formal parameter and returns an array also. 
	public static int[] copyArray (int[] array){
		int[] newArray = new int[array.length];
		int i;

		for (i=0; i < array.length; i++){
			newArray [i] = array [i];  			
		}
		return newArray; 
	}

	public static void main(String[] args) {

		// declares an array of integers
		// allocates memory for 10 integers
		int[] anArray = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		int [] newArray = new int[anArray.length];         	

		System.out.println ("The array has " + anArray.length + " elements.");

		//print the array elements
		System.out.println ("\nPrinting the elements of the array:");
		printArray (anArray); 

		// Summing all elements
		System.out.println("\nThe sum of the elements of the array is " 
				+ addArray (anArray));

		// Finding the largest element
		System.out.println("\nThe maximum element of the array is " 
				+ maxArray(anArray));

		//Print the reversed array
		System.out.println ("\nPrinting the reversed array:");
		printArray (reverseArray (anArray));
		printArray (reverseArray1 (anArray));

		//copying an array
		System.out.println ("\nCopying an array to a new array and printing it: ");
		newArray = copyArray (anArray);
		printArray (newArray);

	}
} 