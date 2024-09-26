package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Searching an array one item quickly using binary search.
 * 			It works when the searched array already is sorted. 
 * Date modified: 10/31/2019
 */

public class O10BinarySearch {

	/** Print an array of ints */
	public static void printArray (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println (); 
	}


	/** Use binary search to find the key in the list of ints */
	public static int binarySearch(int[] list, int key) {
		//To perform binary search, we need two indices or pointers. 
		int low = 0;
		int high = list.length - 1;

		//main code for performing binary search
		while (high >= low) {  //i.e., the length of the array segment to look at is -ve 
			//find the midpoint
			int mid = (low + high) / 2; //it is an integer division
			if (key < list[mid]) //if key is less than list[mid] look at left half
				high = mid - 1;
			else if (key == list[mid])
				return mid; //we have found what we are looking for
			else //if (key > list[mid]) //if key is bigger than list[mid], look at right half
				low = mid + 1;
		}

		return (-1); // Now high < low; Return -1
	}



	public static void main (String[] args){
		//The list to search over must be sorted
		int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
		int j;

		//Print the list and search for keys in the list using binary search
		System.out.println ("The list is:");
		printArray (list);

		j = binarySearch (list, 2);
		System.out.println ("Found 2 at location " + j + " in the array");

		j = binarySearch (list, 11);
		System.out.println ("Found 11 at location " + j + " in the array");

		j = binarySearch (list, 12);
		System.out.println ("Found 12 at location " + j + " in the array");

		j = binarySearch (list, 1);
		System.out.println ("Found 1 at location " + j + " in the array");

		j = binarySearch (list, 3);
		System.out.println ("Found 3 at location " + j + " in the array");

	}
}