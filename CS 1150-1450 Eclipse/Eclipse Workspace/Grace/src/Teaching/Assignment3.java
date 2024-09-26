package Teaching;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment3 {
	public static void main(String args[]) throws IOException{ 
		//initializing variables and arrays
		String names[] = {"Mason", "Bubba", "Jill", "Pat", "Jenny", "Howard", "Buster"};
		int age[] = {25, 44, 16, 18, 21, 44, 8};
		char choice = '0';
		int ageChoice = 0;

		File fileName = new File("AgeNames.txt");
		FileWriter ageNames = new FileWriter(fileName);

		//boolean for "error checking"
		boolean isNone;

		//initializing keyboard
		Scanner input = new Scanner(System.in);

		//program header (personal choice)
		System.out.println("In this program you will be asked questions "
				+ "relating to the age of people\n"
				+ "input X to exit the program");

		//while the input isn't X, keep repeating
		while(choice != 'X') {

			//resetting boolean for "error checking" age inputs
			//if the option they chose has a match, this is set to false
			//if the option they chose has no match, this stays true and prints a message
			isNone = true;

			//presenting user with the options
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println(dtf.format(now));
			
			System.out.print("\nIf you are you interested in:\n"
					+ "A list of names exactly equal to a certain age, input E\n"
					+ "A list of names older than a certain age, input O\n"
					+ "A list of names younder than a certain age, input Y\n"
					+ "Input: ");

			//getting their choice from the input
			choice = input.next().charAt(0);

			//if their choice is E
			if(choice == 'E') {
				//prompt for and take the inputted age they want to check
				System.out.print("Enter the age you would like to check: ");
				ageChoice = input.nextInt();
				ageNames.write("List of people equal to: " + ageChoice + "\n");
				//checking each element of the array to see if it is equal
				for(int i=0; i<age.length; i++) {
					//if it is equal, print and set boolean to false
					if(age[i] == ageChoice) {
						isNone = false;
						System.out.printf("%s : %d\n", names[i], age[i]);
						ageNames.write(names[i] + " : " + age[i] + "\n");
					} //end if
				} //end equal for
				//if nobody matches their inputted age, print message
				if(isNone) {
					System.out.println("Sorry but nobody matches that age");
					ageNames.write("Nobody matched the given age.\n");
				}
				ageNames.write("");
			} //end if E

			//if their choice is O
			else if(choice == 'O') {
				System.out.print("Enter the age you would like to check: ");
				ageChoice = input.nextInt();
				for(int i=0; i<age.length; i++) {
					if(age[i] > ageChoice) {
						isNone = false;
						System.out.printf("%s : %d\n", names[i], age[i]);
					} //end if
				} //end older for
				if(isNone)
					System.out.println("Sorry but nobody is older than that age");
			} //end if O

			//if their choice is Y
			else if(choice == 'Y') {
				System.out.print("Enter the age you would like to check: ");
				ageChoice = input.nextInt();
				for(int i=0; i<age.length; i++) {
					if(age[i] < ageChoice) {
						isNone = false;
						System.out.printf("%s : %d\n", names[i], age[i]);
					} //end if
				} //end younger for
				if(isNone)
					System.out.println("Sorry but nobody is younger than that age");
			} //end if Y

			//if they input X, print a goodbye message
			else if(choice == 'X') {
				System.out.println("Thanks for visiting");
			} //end if X

			//if they enter an invalid input, print invalid
			else
				System.out.println("Invalid input");

		} //end while

		//close keyboard
		input.close();
		ageNames.close();
	} //end main
} //end class