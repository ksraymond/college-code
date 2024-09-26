package Final;

/*pseudocode
a. Create an array to hold 10 integer values (2pt)
b. Using a loop, populate the array with even numbers starting from 0 (e.g. 0, 2, 4, 6, etc). Note: don't prompt the user for input. (5pt)
c. Display the sum of the last two elements using the length property to refer to these elements. (3pts)
d. Write a loop that computes the sum of all the elements in the array (6pts)

 * create an int array the size of 10 called even
 * 	int[] even = new int[10]
 * 
 * create an int for the value inside the array
 * 	int value = 2
 * for(i=0; i<even.length; i++)
 * 	even[i] = value
 * 	value*=2
 * 
 * create an int for the sum of last 2 values called sumLast
 * print sumLast
 * 	sumLast = even[even.length-1] - even[even.length-2];
 * 
 * create an int for the sum of all values called total
 * use a for loop to add together all values in the array
 * print the total
 *  for(i=0; i<even.length; i++)
 *   total+=even[i]
 * 
 */

public class FinalArray {
	
	public static void main(String[] args) {
		
		int[] even = new int[10];  //task a
		int value = 0;
		int sumLast;
		int total = 0;
		
		//task b
		for(int i=0; i<even.length; i++) {
			even[i] = value;
			value+=2;
		}
		
		//task c
		sumLast = even[even.length-1] + even[even.length-2];
		System.out.println("The sum of the last two elements in the array is: " + sumLast);
		
		//task d
		for(int i=0; i<even.length; i++)
			total+=even[i];
		System.out.println("The sum of all elements in the array is: " + total);
	}

}
