package O03Loops;

import java.util.Scanner;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prompts user for 
 * 			number1 + number2 till correct answer is provided
 * 			in less than 5 trials
 * Date modified: 9/17/2019
 */

public class O02RepeatAdditionQuiz {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter two numbers to add: ");

		int number1 = input.nextInt();
		int number2 = input.nextInt();

		System.out.print("What is " + number1 + " + " + number2 + "? "); 
		int answer = input.nextInt();

		int trial = 1;
		while (number1 + number2 != answer && trial < 5) {
			System.out.print("Wrong answer. Please try again. \nWhat is "
					+ number1 + " + " + number2 + "? "); 
			answer = input.nextInt();
			trial++;
		}

		if (number1 + number2 == answer) {
			System.out.println("You got it!");
		}
		else {
			System.out.println("Sorry, your anwer is incorrect!");
		}

		input.close();
	}
}
