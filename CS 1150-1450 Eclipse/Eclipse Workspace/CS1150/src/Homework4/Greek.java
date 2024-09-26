package Homework4;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: to generate a table of greek characters and their unicode value
 * Date modified: 11/3/2019
 */

/*Pseudocode:
 * variables:
 *    int line
 *    int unicode1 = 913 (the decimal value of the top character's hex value in the first column)
 *    int unicode2 = 945 (the decimal value of the top character's hex value in the third column)
 *    char symbol1 = '\u0391' (the unicode value of the top character in the first column)
 *    char symbol2 = '\u03B1' (the unicode value of the top character in the third column)
 *    
 * for(line=0; line < 24; line++)
 * 		if unicode1 is 930  (if statement to exclude the character between P and Σ in column 1)
 * 			symbol1++
 * 			unicode1++
 * 		if unicode2 is 962	(if statement to exclude the character between ρ and σ in column 2)
 * 			symbol2++
 * 			unicode2++
 * 		print symbol1
 * 		tab
 * 		print the part of the unicode that stays constant "\\u0"
 * 		print the hex conversion of int unicode1
 * 		tab x2
 * 		print symbol 2
 * 		tab
 * 		print "\\u0" again
 *		print the hex conversion of int unicode2
 *		new line
 *		add one to symbol1, symbol2, unicode1, and unicode2
 */

public class Greek {
	public static void main(String[] args) {

		//initialize variables
		int line;
		int unicode1 = 913;
		int unicode2 = 945;
		char symbol1 = '\u0391';
		char symbol2 = '\u03B1';

		//for loop to print each line
		for(line=0; line < 24; line++) {

			//excludes the character with value \u03A2
			if(unicode1 == 930) {
				symbol1++;
				unicode1++;
			}
			//excludes the character with value \u03C2
			if(unicode2 == 962) {
				symbol2++;
				unicode2++;
			}

			System.out.print(symbol1);			//print the symbol in the first column
			System.out.print("\t");				//tab
			System.out.print("\\u0");			//first half of printing the unicode value
			System.out.printf("%X", unicode1);	//converts the value of unicode1 from decimal to hex
			System.out.print("\t\t");
			System.out.print(symbol2);
			System.out.print("\t");
			System.out.print("\\u0");			
			System.out.printf("%X", unicode2);
			System.out.print("\n");				//next line

			//increment each variable by 1
			symbol1++;
			unicode1++;
			symbol2++;
			unicode2++;
		}		
	}
}
