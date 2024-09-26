package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Performing bubble sort, where the large elements bubble up to
 * 			end one by one.  
 * Date modified: 10/31/2019
 */

public class O12BubbleSort {

	/** Method to print an array of ints */
	public static void printArray (double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println (); 
	}


	/** Bubble sort method */
	public static void bubbleSort(double[] list) {
		double temp; 

		for (int k = 1; k < list.length; k++) {

			System.out.print ("\nOuter loop (Before): k = " + k + "\t\n\t"); printArray (list); 
			//Bubble up the largest elements one by one to the end of the array.
			//The number of passes is equal to the number of elements in the list.
			for (int i = 0; i < list.length - k; i++) {
				//System.out.print("\n\tInner loop: i = " + i +"; "); printArray (list); 
				if (list [i] > list [i + 1]) {
					// Swap list[i] with list[i + 1]
					temp = list [i];
					list [i] = list [i + 1];
					list[ i + 1] = temp;
				} //if ends
				System.out.print("\n\tInner loop: i = " + i +"; "); printArray (list); 
			}//inner for ends
			System.out.print ("\nOuter loop (After): k = " + k + "\t\n\t"); printArray (list); 

		}//outer for ends
	}//method bubbleSort ends


	/** A test method */
	public static void main(String[] args) {
		double[] list = {1, 9, 4, 5, 6.6, 5.7, -4};

		System.out.print ("Array before sorting:\n\t");
		printArray (list);
		bubbleSort (list);
		System.out.print ("Array after sorting:\n\t");
		printArray (list);
	}
}
