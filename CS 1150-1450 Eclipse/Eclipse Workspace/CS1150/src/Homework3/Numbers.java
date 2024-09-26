package Homework3;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: to ask the user for an unspecified number of integers ending with 0, then print 8 things about the numbers
 * Date modified: 10/20/2019
 */

/*Pseudocode:
 * import decimal format and keyboard
 * variables:
 *    int value, positive, negative, even, odd, max, min, total, count
 *    float average
 * tell user to input integers and that 0 ends the list
 * while(value != 0)
 *       count plus 1
 *     if the value is more than 0
 *       positive plus 1
 *     if the value is less than 0
 *       negative plus 1
 *     if the value modular 2 = 0
 *       even plus 1
 *     if the value modular 2 = 1 or -1
 *       odd plus 1
 *     if the value is greater than the max
 *       max = value
 *     if the value is less than the min
 *       min = value
 *     total + value
 *     average = total / count
 *     value = input.nextint 
 *     
 * if count = 0
 *   System.out.println(no numbers were entered except 0)
 *     
 * System.out.println(Number of positive values = positive)
 * System.out.println(Number of negative values = negative)
 * System.out.println(Number of even values = even)
 * System.out.println(Number of odd values = odd)
 * System.out.println(Largest value entered = max)
 * System.out.println(Smallest value entered = min)
 * System.out.println(Sum of all numbers = total)
 * System.out.println(Average = average)
 */

//importing decimal formatting and keyboard
import java.util.Scanner;
import java.text.DecimalFormat;

public class Numbers {
	public static void main(String[] args) {

		System.out.println("Enter a list of integer values, enter the number 0 to end the list.");

		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat(".00");

		int value = input.nextInt();
		int positive = 0;
		int negative = 0;
		int even = 0;
		int odd = 0;
		int max = value;
		int min = value;
		int total = 0;
		int count = 0;
		float average = 0;

		while(value != 0) {

			count++;

			if (value > 0)
				positive++;

			if (value < 0)
				negative++;

			if (value % 2 == 0)
				even++;

			if (value % 2 == 1 || value % 2 == -1)
				odd++;

			if (value > max) 
				max = value;

			if (value < min) 
				min = value;

			total += value;
			average = (float)total / count;
			value = input.nextInt();
			
		}

		if (count == 0) {
			System.out.println("No numbers were entered except 0");
			System.exit(1);
		}

		input.close();


		System.out.println("Number of positive values = " + positive);
		System.out.println("Number of negative values = " + negative);
		System.out.println("Number of even values = " + even);
		System.out.println("Number of odd values = " + odd);
		System.out.println("Largest value entered = " + max);
		System.out.println("Smallest value entered = " + min);
		System.out.println("Sum of all numbers = " + total);
		System.out.println("Average = " + df.format(average));
	}
}