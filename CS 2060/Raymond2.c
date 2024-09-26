/*Keaton Raymond
CS2060 - 002
Simple Calculator
Due Date: 3/12/2020
Description: This program will perform four basic math
	functions on operands the user inputs using function
	pointers. The program will ask the user for what
	operation they would like to run and will let them
	continuously do operations until they decide to exit.
	Each math function will have its own function which
	will be called through an array of function pointers
	for the four functions. Each function will print the 
	equation without the answer and return the answer.
	The loop in main will then print the answer.
*/

#include <stdio.h>

//prototypes
float add(float oper1, float oper2);
float subtract(float oper1, float oper2);
float multiply(float oper1, float oper2);
float divide(float oper1, float oper2);
void printHeading();

int main(int argc, char * argv[]) {
	
	//initializing variables and array
	int menuChoice; //not initialized to make while loop work
	float oper1 = 0;
	float oper2 = 0;
	float answer = 0;
	float (*operation[4])(float, float) = 
		{add, subtract, multiply, divide};
	
	//call to method to print heading
	printHeading();
	
	//while loop to keep doing operations as long as the 
	//user doesn't exit
	while(menuChoice != 0) {		
		printf("\n\nEnter what operation "
		"you would like to do > ");
		scanf("%d", &menuChoice);
		
		//if the menu choice is one of the four functions
		//ask for operands and do operation
		if(menuChoice > 0 && menuChoice <=4) {
			printf("Enter the two operands > ");
			scanf("%f", &oper1);
			scanf("%f", &oper2);
			
			//call to correct math function, -1 to account
			//for 0 index
			answer = (*operation[menuChoice-1])
			(oper1, oper2);
			printf("%.2f", answer);
		} //end if
		//if user inputs 0 print goodbye message
		else if(menuChoice == 0) {
			printf("\nThank you for using Keaton's Simple"
			" Calculator. Goodbye.");
		} //end else if
		
	} //end while
	
return 0;
} //end main	

//method to add two operands
float add(float oper1, float oper2) {
	printf("%.2f + %.2f = ", oper1, oper2);
	return oper1+oper2;
} //end add

//method to subtract two operands
float subtract(float oper1, float oper2) {
	printf("%.2f - %.2f = ", oper1, oper2);
	return oper1-oper2;
} //end subtract

//method to multiply two operands
float multiply(float oper1, float oper2) {
	printf("%.2f * %.2f = ", oper1, oper2);
	return oper1*oper2;
} //end multiply

//method to divide two operands
float divide(float oper1, float oper2) {
	printf("%.2f / %.2f = ", oper1, oper2);
	return oper1/oper2;
} //end divide

//method to print heading
void printHeading() {
	printf("Welcome to Keaton's Simple Calculator\n"
	"  This program asks for two operands and"
	"\n  what operation you would like to do on them."
	"\n  Then prints out the answer for you."
	"\n\n0 > exit"
	"\n1 > add"
	"\n2 > subtract"
	"\n3 > multiply"
	"\n4 > divide");
} //end printHeading
