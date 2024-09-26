//Keaton Raymond
//CS 2060 - 002
//

#include <stdio.h>

int main(int argc, char ** argv[]) {
	
	char initial = '\0'; //initialized to null
	
	//print welcome and description
	printf("\nWelcome to Keaton's Hello World Program\n\n");
	
	//get user's middle initial and print message with initial
	printf("input your middle initial > ");
	scanf("%c", &initial); //initializer for reading a char, variable "initial", need &
	printf("Hello, your middle initial is %c", initial);
	
} //end main



