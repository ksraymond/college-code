package Homework5;

/* Programmer: Keaton Raymond
 * Class: CS 1150 - 003
 * Purpose: check if the user input is a prime number and if it isn't,
 * 			find the closest prime number that is smaller than the input
 * Date modified: 11/17/2019
 */

/*Pseudocode:
 * variables:
 * int number
 * nearestPrime = getNearestPrime(number);
 * 
 * prompt user to input a positive, non-zero integer
 * 
 * main method:
 * if number == 1
 * 	print n + is not prime.\n We cannot find the nearest prime
 * 	System.exit(1);
 * 
 * if isValid is false
 * 	print "Sorry your input is not valid. Bye."
 * 	System.exit(1);
 * if isValid is true
 * 	invoke isPrime
 * 
 * if isPrime is true
 * 	System.out.println(number + " is prime");
 * if isPrime is false
 * 	invoke getNearestPrime
 * 	System.out.println("The nearest prime is " + nearestPrime);
 * 
 * 
 * isValid method:
 * public static boolean isValid (int number)
 * 	if number > 0 
 * 		return true
 * 	else
 * 		return false
 * 
 * 
 * isPrime method:
 * public static boolean isPrime (int number)
 * 	boolean isPrime = true;
 * 	for(int i=2; i < number; i++)
 * 		if number % i = 0
 * 			isPrime = false
 * 	return isPrime
 * 
 * 
 * getNearestPrime method:
 * public static int getNearestPrime(int number)
 * boolean prime = false;
 * int nextPrime = number;
 * while prime == false
 * 	nextPrime -= 1
 * 	for(int i=2; i < nextPrime; i++)
 * 		if nextPrime % i = 0
 * 			prime = false
 * 			break
 * 		else if nextPrime % i != 0
 * 			prime = true
 * 
 */

import java.util.Scanner;

public class Prime {

	//main method
	public static void main(String[] args) {

		//asking for input
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a positive, non-zero integer: ");
		int number = input.nextInt();
		input.close();

		//in the special case of the number being less than 2 but more than 0 it must be 1
		if(number == 1) {
			System.out.println(number + " is not prime.\nWe cannot find the nearest prime");
			System.exit(1);
		} //end if statement

		//if the input is less >= 0, exit
		if(isValid(number) == false) {
			System.out.println("Sorry your input is not valid. Bye.");
			System.exit(1);
		} //end if statement
		int nearestPrime = getNearestPrime(number);
		//if the number is prime
		if(isPrime(number) == true)
			System.out.println(number + " is prime");
		//if the number is not prime, invoke the method to find the nearest prime less than the input
		else
			System.out.println(number + " is not prime.\nThe nearest prime is " + nearestPrime);
	} //end main method 

	//method to test if the inputs meet the parameters
	public static boolean isValid(int number) {
		if(number > 0)
			return true;
		else
			return false;
	} //end isValid method

	//method to test if the input is prime
	public static boolean isPrime(int number) {
		int i;
		boolean isPrime = true;
		for(i=2; i < number; i++) {
			if(number % i == 0)
				isPrime = false;
		} //end for loop
		return isPrime;
	} //end isPrime method

	//method to find the nearest prime number if the input is not prime
	public static int getNearestPrime(int number) {
		boolean prime = false;
		int nextPrime = number;
		while(prime == false) {
			nextPrime -= 1;
			for(int i=2; i < nextPrime; i++) {
				if(nextPrime % i == 0) {
					prime = false;
					break;
				} //end if statement
				else
					prime = true;
			} //end for loop
		} //end while loop
		return nextPrime;
	} //end getNearestPrime method

} //end program
