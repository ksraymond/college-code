package O04NumStrings;
import java.util.Scanner;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Declaring and printing characters
 * Date modified: 10/1/2019
 */

public class O06Char2 {
	public static void main (String[] args){
		char c;

		Scanner keyboard;
		keyboard = new Scanner (System.in);

		System.out.println ("Enter a single character: ");
		//Read the entire next line, but look at the first character at position 0
		c = keyboard.nextLine().charAt(0); 
		// next() will work too, next() reads till the space: can't read two words separated by space
		//c = keyboard.next().charAt(0);
		keyboard.close();

		//The Character class is Java provides some methods that can be used with chars
		if (Character.isDigit(c)){   
			System.out.println ("You entered a digit " + c);
		} 
		else if (Character.isLetter(c)){
			System.out.println ("You entered a letter: " + c );

			if (Character.isUpperCase(c)){
				System.out.println ("You entered an uppercase letter: " + c);
				System.out.println ("Its lowercase version is: " + Character.toLowerCase (c));
			}
			else 
			{
				System.out.println ("You entered an lowercase letter: " + c);
				System.out.println ("Its uppercase version is: " + Character.toUpperCase (c));
			}


		}
	}
}

