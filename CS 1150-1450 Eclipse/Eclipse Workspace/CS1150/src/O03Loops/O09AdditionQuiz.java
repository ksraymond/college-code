package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that generates addition questions and 
 * 			gives a score.
 * Date modified: 9/17/2019
 */

import java.util.Scanner;

public class O09AdditionQuiz {
	public static void main(String[] args) {
		int number1, number2, correctSum, studentAnswer, studentScore;
		final int TOTAL_TRIES = 5; 

		Scanner keyboard = new Scanner(System.in);     // Create a Scanner

		number1 = (int)(Math.random() * 10); //generate a random number >=0 and <10
		number2 = (int)(Math.random() * 10); //generate another random number >= 0 and < 10
		correctSum = number1 + number2;

		studentScore = TOTAL_TRIES; //initial value of student score

		//Ask the question
		System.out.print("What is " + number1 + " + " + number2 + "?\n");

		//Allow only a few tries, reduce score after each wrong answer
		for (int i=1; i < TOTAL_TRIES+1; i++){
			//Prompt for the student to answer
			System.out.print ("Attempt " + i + ": \n");
			//Get the student's answer
			studentAnswer = keyboard.nextInt();

			//Get out of the loop when the student gets the correct answer 
			if (correctSum == studentAnswer){
				break;
			}  

			studentScore = studentScore - 1; 
		}//end of for loop

		keyboard.close();
		//Give the score out
		System.out.println ("You receive " + studentScore + " out of " + TOTAL_TRIES + " points"); 

	}
}
