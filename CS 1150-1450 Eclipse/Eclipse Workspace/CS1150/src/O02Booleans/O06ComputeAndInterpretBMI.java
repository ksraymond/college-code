package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Computing Body Mass Index (BMI) values and reporting 
 * 			BMI = weight in kilograms/(height in meters) ^ 2
 * 			BMI < 18.5: Underweight; 18.5 <= BMI < 25.0: Normal; 
 * 			25.0 <= BMI < 30.0: Overweight;
 * 			30.0 <= BMI : Obese
 * Date modified: 9/6/2019
 */

import java.util.Scanner;

public class O06ComputeAndInterpretBMI {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);

		double weight, height; 
		double weightInKilograms, heightInMeters, bmi;

		final double KILOGRAMS_PER_POUND = 0.45359237; // Constant
		final double METERS_PER_INCH = 0.0254; // Constant 

		// Prompt the user to enter weight in pounds
		System.out.print("Enter weight in pounds: ");
		weight = keyboard.nextDouble();

		// Prompt the user to enter height in inches
		System.out.print("Enter height in inches: ");
		height = keyboard.nextDouble();
		keyboard.close();

		// Compute BMI
		weightInKilograms = weight * KILOGRAMS_PER_POUND; 
		heightInMeters = height * METERS_PER_INCH; 
		bmi = weightInKilograms / 
				(heightInMeters * heightInMeters);

		// Display result
		System.out.printf("Your BMI is %5.2f\n", bmi);
		if (bmi < 16.0){
			System.out.println("You are severely underweight");
		}
		else if (bmi < 18.5){
			System.out.println("You are underweight");
		}
		else if (bmi < 25.0){
			System.out.println("You are normal weight");
		}
		else if (bmi < 30.0){
			System.out.println("You are overweight");
		}
		else if (bmi < 35){
			System.out.println("You are seriously overweight");
		}
		else{
			System.out.println("You are gravely overweight");
		}
	}
}
