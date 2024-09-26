package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Given names of two cities as Strings, comparing them 
 *          and writing them in order
 * Date modified: 10/1/2019
 */

import java.util.Scanner;


public class O08Order2Cities {
	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
	 
		 // Prompt the user to enter two cities
		 System.out.print("Enter the first city: ");
		 String city1 = input.nextLine();
		 System.out.print("Enter the second city: ");
		 String city2 = input.nextLine();
		 input.close();
	
		 //compareTo gives 0 if the two strings are equal; <0 if the first string is smaller 
		 //alphabetically, and >0 if the first string is bigger alphabetically
		 if (city1.compareTo(city2) < 0){
			 System.out.println("The cities in alphabetical order are " +
			 city1 + " followed by " + city2);
		 }
		 else if (city1.compareTo(city2) > 0){
			 System.out.println("The cities in alphabetical order are " +
					 city2 + " followed by " + city1);
			 }
		 else {
			 System.out.println("The cities " + city2 + " and " + city1 +
					 " are alphabetically the same");
		 }
	}
}
