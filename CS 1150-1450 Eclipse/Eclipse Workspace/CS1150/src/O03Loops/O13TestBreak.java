package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: A class that tests break in a while loop.
 * Date modified: 9/17/2019
 */

public class O13TestBreak {
	public static void main(String[] args) {
		int sum = 0;
		int number = 0;

		while (number < 20) {
			number++;
			System.out.println("number: " + number);

			sum += number;
			System.out.println("sum: " + sum);

			if (sum >= 100) 
				break;

			System.out.println();
		}

		System.out.println("The number is " + number);
		System.out.println("The sum is " + sum);
	}
}

