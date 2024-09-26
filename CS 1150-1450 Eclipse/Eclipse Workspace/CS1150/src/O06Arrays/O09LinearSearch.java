package O06Arrays;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Searching for a key in an array one item at a time from index 0.
 * 			The input array is not sorted. 
 * Date modified: 10/31/2019
 */

public class O09LinearSearch {

	//Print an array of ints
	public static void printArray (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println (); 
	}

	//Print an array of Strings; overloaded method name
	public static void printArray (String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println (); 
	}

	//The method for finding a key in the list of ints
	//key is an int we are searching for
	public static int linearSearch(int[] list, int key) {
		for (int i = 0; i < list.length; i++) {
			if (key == list[i])
				return i;  //return the location in the list where we found the key
		}
		return -1;  //return -1 if we cannot find the key in the list
	}

	//The method for finding a key in the list of Strings
	//key is a String we are searching for
	//overloaded method name
	public static int linearSearch(String[] list, String key) {
		for (int i = 0; i < list.length; i++) {
			if (key.equals(list[i]))
				return i;  //return the location in the list where we found the key
		}
		return -1;  //return -1 if we cannot find the key in the list
	}

	//main method that calls linearSearch
	public static void main (String[] args){
		int [] intList = {1, 4, 4, 2, 5, -3, 6, 2};
		int i;
		String [] nameList = {"Ahmed", "Hunter", "Alexander", "Brooks", "John", "Michael",
				"Nicholas", "Jason", "Rebecca", "Jeremy", "Christopher", "Kevin"};
		String name; 


		//print the list of integers
		System.out.println ("Our list of integers is:");
		printArray (intList);

		//---------Searching in a list of ints
		//Look for 4 in intList and return its position
		i = linearSearch (intList, 4);
		System.out.println ("Found 4 " + " at location " + i);

		//Find -4 in intList and return its position
		i = linearSearch (intList, -4);
		System.out.println ("Found -4 " + " at location " + i);

		//Find -3 in intList and return its position
		i = linearSearch (intList, -3);
		System.out.println ("Found -3 " + " at location " + i);

		//----Searching in a list of Strings
		System.out.println ("\nOur list of names is:");
		printArray (nameList);
		//Search for names 
		name = "Ahmed";
		i = linearSearch (nameList, name);
		System.out.println ("Found " + name + " at location " + i);

		name = "Jason";
		System.out.println ("Found " + name + " at location " + 
				linearSearch (nameList, name));

		name = "Colin";
		System.out.println ("Found " + name + " at location " + 
				linearSearch (nameList, name));

	}

}
