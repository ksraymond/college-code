package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Print results of arithmetic expressions to console
 * Date modified: 8/24/2019
 */

public class O04Arithmetic {

	// The main method that performs the arithmetic computation, with variable declaration
	public static void main (String args[]){
		//int x; // x, and y are variables declared for use in the computation
		//int y;
		int x, y;
		int sum, difference, product; 

		//assigning values and performing the computation
		x = 20; 
		y = 30;

		sum = x + y; 
		difference = x - y;
		product = x * y;

		//printing the results, we can print each part separately
		System.out.print("sum = ");
		System.out.print(sum);
		System.out.print("\n");
		System.out.print("difference = ");
		System.out.print(difference);
		System.out.print("\n");
		System.out.print("product = ");
		System.out.print(product);
		System.out.print("\n");
		System.out.print("---------\n");


		//Or, we can print them in one single command by building 
		//a string as argument to println
		System.out.println("sum = " + sum + "\n" + 
				"difference = " + difference + "\n" + 
				"product = " + product);

	}
}
