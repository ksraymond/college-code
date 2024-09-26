package O01Basics;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that computes algebraic expressions
 * Date modified: 8/24/2019
 */

public class O03ComputeExpression {

	public static void main(String[] args){

		//Simple arithmetic expressions, printing results
		//System.out.println() prints only strings, but converts number to string to print
		System.out.println(10 + 2);  //integer add
		System.out.println(10 - 2);  //integer subtract
		System.out.println(10 * 2);  //integer multiply
		System.out.println(10 / 2);  //integer divide

		System.out.println(10 / 3);   //integer divide again, produces integer answers

		System.out.println(10.0 + 2.0); //floating point arithmetic
		System.out.println(10.0 - 2.0);  
		System.out.println(10.0 * 2.0);  
		System.out.println(10.0 / 2.0); 	

		//mixed arithmetic, fully parenthesized, automatically converted to the bigger
		System.out.println((10.5 + 2 * 3) / (45 - 3.5)); 

	}
}
