package Midterm;

import java.util.Scanner;
import java.text.DecimalFormat;

/*pseudocode
 * • Prompts user for a list of integer values. We can assume the user input is always integer(s). (4pts)
• The end of the list is specified by the number zero (e.g.  34 23 81 72 16 0) (4pts)
• Finds the average of the list of values entered by the user, and displays it with two decimal points. Input 0 is not included in the calculation. (7pts)
• Finds the smallest value entered by the user, and displays it. Input 0 is not included in the calculation. (5pts)

 * import scanner and decimal format
 * int count = 0
 * int value = 0
 * int total = 0
 * int min = 0
 * double average = 0
 * while value != 0
 * count += 1
 * total += value
 * if value < min && (value < 0 || value > 0)
 *  min = value
 * 
 * average = total / (count - 1)
 * system.out.print ( the smallest number is: min \n the average is: average)
 * 
 */

public class MidtermCode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat(".00");

		System.out.println("Enter a list of integer values, enter the number 0 to end the list.");
		int value = input.nextInt();
		int min = value;
		int count = 0;
		int total = 0;
		double average;
		while(value != 0) {
			value = input.nextInt();
			if (value != 0)
				count += 1;
			total += value;
			if (value < min && (value < 0 || value > 0)) 
				min = value;

		}
		input.close();

		average = total / count;
		System.out.print("The smallest number in the set is: " + min + 
				"\nThe average of the set is: " + df.format(average));

	}
}
