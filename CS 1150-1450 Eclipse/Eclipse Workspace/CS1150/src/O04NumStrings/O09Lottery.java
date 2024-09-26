package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Generates a random two-digit number, then prompts 
 * 		the user to enter a two-digit number, and determines 
 * 		whether the user wins according to the following rule:
 * 		1. If the user input matches the lottery number in the exact order, 
 * 			the award is $10,000.
 * 		2. If all the digits in the user input match all the digits in the 
 * 			lottery number, the award is $3,000.
 * 		3. If one digit in the user input matches a digit in the lottery 
 * 			number, the award is $1,000.
 * Date modified: 10/1/2019
 */

import java.util.Scanner;

public class O09Lottery {
	public static void main(String[] args) {
		// Generate a lottery as a two-digit string
		String lottery = (int)(Math.random() * 10) + "" 
				+ (int)(Math.random() * 10);		
		
		// Get digits from lottery
		char lotteryDigit1 = lottery.charAt(0);
		char lotteryDigit2 = lottery.charAt(1);
 
		// Prompt the user to enter a guess
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (two digits): ");
		String guess = input.nextLine();
		input.close();

		// Get digits from guess
		char guessDigit1 = guess.charAt(0);
		char guessDigit2 = guess.charAt(1);
		
		System.out.println("The lottery number is " + lottery);
		 
		 // Check the guess
		 if (guess.equals(lottery))
			 System.out.println("Exact match: you win $10,000");
		 	else if (guessDigit2 == lotteryDigit1
		 			&& guessDigit1 == lotteryDigit2)
		 		System.out.println("Match all digits: you win $3,000");
		 	else if (guessDigit1 == lotteryDigit1
		 			|| guessDigit1 == lotteryDigit2
		 			|| guessDigit2 == lotteryDigit1
		 			|| guessDigit2 == lotteryDigit2)
		 		System.out.println("Match one digit: you win $1,000");
		 	else
		 		System.out.println("Sorry, better luck next time!");
		 		
		
	}
}