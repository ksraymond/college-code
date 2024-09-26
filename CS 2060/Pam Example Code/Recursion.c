/* CS2060
 * Recursion Example n!
 * This program caluculates n! (n Factorial) using Recursion.
 * The purpose is to demonstrate how the stack creates a new copies of local
 * (non-static) variables everytime a function is called. 
 * A long (long int) is used, because 2,147,483,647 is the largest value a
 * 32 bit signed int can hold  and 13! = 6,227,020,800.
 */

#include <stdio.h>

long recursor( int );

int main(int argc, char *argv[]) {
	
	long result = 0;	//long int - result gets large very fast
	int n = 0;
	
	//Print welcome, description, and get n.
	printf("Welcome to Pam\'s stolen N! Factorial Calculator\n");
	printf("input N > ");
	scanf("%d", &n);
	
	//call recursive function to find n! and print result
	result = recursor(n);
	printf("For n = %d, n! = %ld", n, result);
	
	return 0;
}


long recursor( int n ){
//calculate n! using recursion
	
	long int answer = 0;
	
	if ( n - 1 > 0)
		answer = n* recursor( n-1 );
	else
	//BASE CASE - unwinds the call stack
	//only used in the very last call to this function 
		answer = 1;				

	return answer;		
}
