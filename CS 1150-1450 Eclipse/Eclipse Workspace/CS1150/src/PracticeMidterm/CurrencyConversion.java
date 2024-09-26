package PracticeMidterm;

import java.util.Scanner;
import java.text.DecimalFormat;

/*pseudocode
 * Write a program that prompts the user to enter the exchange rate
 * from currency in U.S. dollars (USD) to Canadian dollars (CAD).
 * Prompt the user to enter 0 to convert from USD to CAD and 1 to convert from CAD to USD.
 * Prompt the user to enter the amount in USD or CAD to convert it accordingly.
 * 
 * decimal format for 2 0s
 * double rate
 * int choice
 * double money
 * ask for exchange rate from USD to CAD
 * prompt user to enter 0 for USD to CAD and 1 for CAD to USD
 * if choice is 0 ask for amount of USD and print amount in CAD
 * if choice is 1 ask for amount of CAD and print amount in USD
 * else print incorrect input
 */
public class CurrencyConversion {

	public static void main(String[] args) {
		double rate, money, solution;
		int choice;
		DecimalFormat df = new DecimalFormat(".00");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the exchange rate from USD to CAD: ");
		rate = input.nextDouble();
		
		System.out.print("Enter 0 to convert USD to CAD and 1 vice versa:");
		choice = input.nextInt();

		if(choice==0) {
			System.out.print("Enter the USD amount:");
			money = input.nextDouble();
			solution = money * rate;
			System.out.print(df.format(money) + "USD is " + df.format(solution) + "CAD");
		}
		
		else if(choice==1) {
			System.out.print("Enter the CAD amount:");
			money = input.nextDouble();
			solution = money / rate;
			System.out.print(df.format(money) + "CAD is " + df.format(solution) + "USD");
		}
		
		else {
			System.out.print("Incorrect Input");
		}
		
		input.close();
	}
}
