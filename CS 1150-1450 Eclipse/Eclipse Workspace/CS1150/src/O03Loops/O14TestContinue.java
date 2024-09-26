package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: A class that tests continue in a while loop.
 * Date modified: 9/17/2019
 */

public class O14TestContinue {
	public static void main(String[] args) {
		int sum = 0;
		int number = 0;

		while (number < 20) {
			number++;
			System.out.println("number: " + number);

			if (number == 10 || number == 11) 
				continue;
			sum += number;

			System.out.println("sum: " + sum);
			System.out.println();
		}

		System.out.println("The sum is " + sum);
	}
}

