package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Performing selection sort
 * Date modified: 10/31/2019
 */

public class O11SelectionSort {

	/** Method to print an array of ints */
	public static void printArray (double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		} 
		System.out.println (); 
	}


	/** The method for sorting the numbers: Selection Sort */
	public static double[] selectionSort(double[] list) {

		for (int i = 0; i < list.length - 1; i++) {

			System.out.print ("\ti = " + i + "; "); printArray (list);
			System.out.println ("\tFind minimum from index i=" + i + " to end of list" );

			// Find the minimum in the list[i..list.length-1]
			double currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
				System.out.println("\t\tj = " + j + "; currentMin = " + currentMin); 
			}

			// Swap list[i] with list[currentMinIndex];
			list[currentMinIndex] = list[i];
			list[i] = currentMin;
			System.out.println("\t\t" + currentMin + " goes from location " + 
					currentMinIndex + " to location " + i); 

		}

		return (list);
	}


	public static void main (String[] args){
		double[] list = {1, 9, 4, 5, 6.6, 5.7, -4.5};

		//print the array and then the sorted array
		System.out.print ("Array before sorting:\n\t");
		printArray (list);
		selectionSort (list);
		System.out.print ("Array after sorting:\n\t");
		printArray (list);
	}

}
