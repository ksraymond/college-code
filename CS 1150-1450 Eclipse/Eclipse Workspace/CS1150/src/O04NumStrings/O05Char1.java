package O04NumStrings;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Declaring and printing characters
 * Date modified: 10/1/2019
 */

public class O05Char1 {
	public static void main (String[] args){
		//Declare some char variables		
		char a = 'a';
		char b = 'b';		
		char newLine = '\n';
		char tab = '\t';
		char poundSign = '\u00a3';
		char nine = '9';
		char period ='.';
		char singleQuote = '\'';		//special characters have to start with a \ to print
		char doubleQuotes = '\"';
		char backSlash = '\\';

		//Print characters by themselves
		System.out.print (a);
		System.out.print (b);
		System.out.print (newLine);

		//Print a tab and special characters 
		System.out.print (a);
		System.out.print (tab);
		System.out.print (b);
		System.out.print (newLine);

		//Print single quote
		System.out.print (singleQuote); 
		System.out.print (a); 
		System.out.println(singleQuote);

		//Print double quotes
		System.out.print (doubleQuotes); 
		System.out.print (a); 
		System.out.println(doubleQuotes);

		//Print back slash
		System.out.print (backSlash); 
		System.out.print (a); 
		System.out.println(backSlash);

		//Print a currency amount
		System.out.print (poundSign);
		System.out.print (nine);
		System.out.print (period);
		System.out.print (nine);
		System.out.println (nine);

		// concatenate chars to form a String
		System.out.print ("" + poundSign + nine + period + nine + nine + newLine);
		//have to concatenate with an empty string to read as a string

		// System.out.printf and System.out.format behave the same
		System.out.printf ("%c%c%c%c%c%c", poundSign, nine, 
				period, nine, nine, newLine);
		System.out.printf ("%c9.99", poundSign);

	}
}
