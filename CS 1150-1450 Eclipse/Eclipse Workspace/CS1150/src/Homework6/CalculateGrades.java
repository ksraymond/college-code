package Homework6;

import java.util.Scanner;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: read 6 student's scores, finds the best score,
 * 			and assigns a letter grade based on where the other grades are
 * 			in relation to the best score
 * Date modified: 12/1/2019
 */

/*Pseudocode:
 * variables:
 * 	int to bring array back to main method
 * 	int array for grades
 * 		grades must be between 0-100, if it is not ask for input again until it is between 0-100
 * 	char array for letter grades
 * 	int bestGrade
 * 
 * methods:
 * 	main method: public static void main(String[] args)
 * 	get and store grades: public static void getGrades(int[] grades, Scanner input)
 * 	find the best grade: public static int findBestGrade(int[] grades)
 * 	determine letter grades: public static void computeLetterGrades(int[] grades, char[] letterGrades, int bestGrade)
 * 	display table with each student info: public static void displayGrades(int[] grades, char[] letterGrades)
 * 
 * main method:
 * 	int[] grades = new int[6]
 * 	char[] letterGrades = new char[6]
 * 	Scanner input = new Scanner(System.in);
 * 
 * get and store grades method:
 * 	for (int i=0, student = 1; i < grades.length; i++, student++)
 * 		system.out.println("Enter grade for student " + student + ":");
 * 		grades[i] = input.nextInt();
 * 		while(grades[i] < 0 || grades[i] > 100)
 * 			System.out.println("\tError! Numeric grade must be between 0 and 100, enter grade again:")
 * 			grades[i] = input.nextInt();
 * 
 * find best grade method:
 * 	int max = grades[0];
 * 	for(int i = 1; i < grades.length; i++)
 * 		if(grades[i] > max) 
 * 			max = grades[i]
 * 	return max
 * 
 * letter grades method:
 * 	for(int i=0; i < grades.length; i++)
 * 		if(grades >= (bestGrade-10)
 * 			letterGrades[i] = 'A'
 * 		if(grades >= (bestGrade-20)
 * 			letterGrades[i] = 'B'
 * 		if(grades >= (bestGrade-30)
 * 			letterGrades[i] = 'C'
 * 		if(grades >= (bestGrade-40)
 * 			letterGrades[i] = 'D'
 * 		else
 * 			letterGrades[i] = 'F'
 * 
 * table with student info method:
 * 	System.out.println("Student\tGrade\tLetter Grade");
 * 	for(int line=0, student = 1; line <= grades.length; line++, student++)
 * 		System.out.println(student + "\t" + grades[line] + "\t" + letterGrades[line];
 */

public class CalculateGrades {

	public static void main(String[] args) {

		//making arrays, variables, and sending values to the other methods
		Scanner input = new Scanner(System.in);
		int[] grades = new int[6];
		char[] letterGrades = new char[6];
		getGrades(grades, input);
		int bestGrade = findBestGrade(grades);
		computeLetterGrades(grades, letterGrades, bestGrade);
		displayGrades(grades, letterGrades);
	}

	//void method to take the input of the grades
	public static void getGrades(int[] grades, Scanner input) {
		//for loop to get 6 grades
		for (int i=0, student = 1; i < grades.length; i++, student++) {
			System.out.print("Enter grade for student " + student + ":");
			grades[i] = input.nextInt();
			//if the grade is not between 0-100, it will ask for a different grade until it is
			while(grades[i] < 0 || grades[i] > 100) {
				System.out.print("  Error! Numeric grade must be between 0 and 100, enter grade again:");
				grades[i] = input.nextInt();
			}
		}
	}

	//method to find the highest grade, tests if each one is higher than the max grade, if it is it becomes the max
	public static int findBestGrade(int[] grades) {
		int max = grades[0];
		for(int i = 1; i < grades.length; i++) {
			if(grades[i] > max) 
				max = grades[i];
		}
		return max;
	}

	//compares all of the grades to the highest grade and assigns it the coresponding letter grade
	public static void computeLetterGrades(int[] grades, char[] letterGrades, int bestGrade) {
		for(int i=0; i < letterGrades.length; i++) {
			if(grades[i] >= (bestGrade-10))
				letterGrades[i] = 'A';
			else if(grades[i] >= (bestGrade-20))
				letterGrades[i] = 'B';
			else if(grades[i] >= (bestGrade-30))
				letterGrades[i] = 'C';
			else if(grades[i] >= (bestGrade-40))
				letterGrades[i] = 'D';
			else
				letterGrades[i] = 'F';
		}
	}

	//prints the table of the students grades with appropriate spacing
	public static void displayGrades(int[] grades, char[] letterGrades) {
		System.out.println("Student\t\tGrade\t\tLetter Grade");
		for(int line=0, student = 1; line < grades.length; line++, student++)
			System.out.println(student + "\t\t" + grades[line] + "\t\t\t" + letterGrades[line]);
	}

}
