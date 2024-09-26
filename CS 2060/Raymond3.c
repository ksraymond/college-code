/*Keaton Raymond
CS2060 - 002
Stack using Pointers
Due Date: 3/20/2020
Description: This program will implement a stack and
	use pointer arithmetic for everything. There will
	be three different functions for the user to choose
	from: unwind, push, and pop. Unwind is the exit
	function that calls pop in a loop and empties out
	the stack before exiting the program. Push will
	prompt the user for a value they would like to
	push (add) onto the stack. Pop will pop (remove)
	off the last number added to the stack. The three
	functions will have identical parameters and 
	return types and will be stored in an array of
	function pointers. Everything to do with the stack
	will all be done through the use of one pointer
	called top. All variables are local variables aside
	from the size of the stack and the stack itself.
*/

#include <stdio.h>
#define SIZE 5 //global variable for size

//global stack
float stack[SIZE] = {0};

//prototypes
float unwind(float* top);
float push(float* top);
float pop(float* top);
void printHeading(void);

int main(int argc, char * argv[]) {
	
	//declaring variables and array of function pointers
	int menuChoice = 0;
	float *top = stack;
	float (*command[3])(float*) = {unwind, push, pop};
	
	//call to function to print the heading
	printHeading();
	
	//do while loop to keep asking for commands as long as the 
	//user doesn't exit
	do {
		printf("\n\nEnter what you would like to do > ");
		scanf("%d", &menuChoice);
		
		//if the menu choice is valid, call the correct function
		if(menuChoice >= 0 && menuChoice <=2)
			*top = ((*command[menuChoice]) (top));
		
		//if menu choice is invalid, tell user to try again
		else
			printf("Invalid Input, try again.");
		
	//if the menu choice is 0, exit the program after still calling 0 function	
	} while(menuChoice != 0);  //end do while
	
	return 0;
} //end main

//function to "unwind" (empty) out the stack
float unwind(float* top) {
	
	//if the stack is already empty, don't call pop
	if(*top == 0) {
		printf("The stack is already empty, goodbye.");
	} //end if the stack is full
	
	//if there are values in the stack, loop calling pop
	else{
		for(int i = (SIZE-1); i >= 0; i--) {
			
			//only call pop for values in the stack
			if(*(top+i) != 0) {
				pop(top+i);
			} //end if
			
		} //end for
		printf("\nThe stack is now empty, goodbye.");
	} //end else
	
	return *top;
} //end unwind

//function to "push" a value onto the stack
float push(float* top) {
	
	//if the stack is full, print an error message
	if(*(top + (SIZE - 1)) != 0) {
		printf("ERROR > The stack is full");		
	} //end if
	
	//if the stack is not full, prompt for value and add to stack
	else {
		//for loop finding the next open spot in the stack
		for(int i=0;i < SIZE; i++) {
			if(*(top + i) == 0) {
				printf("Enter the value you would like to push onto the stack > ");
				scanf("%f", (top + i));
				i = SIZE;
			} //end if
		} //end for
	} //end else

	return *top;
} //end push

//function to "pop" a value off of the top of the stack
float pop(float* top) {
	
	//if stack is empty, print an error message
	if(*top == 0) {
		printf("ERROR > The stack is empty");
	} //end if the stack is full
	
	//if the stack is not full, pop off the top value
	else{
		
		//for loop finding last value in the stack
		for(int i=0;i < SIZE; i++) {
			//find open slot, remove value before it
			if(*(top + i) == 0) {
				printf("\nThe value that was popped off of the stack was > %.2f", *((top + (i-1))));
				*(top + (i-1)) = 0;
				i = SIZE;
			} //end if
			
			//if the stack is full, remove the last value
			else if(*(top + (SIZE - 1)) != 0) {
				printf("\nThe value that was popped off of the stack was > %.2f", *((top + (SIZE - 1))));
				*(top + (SIZE-1)) = 0;
				i = SIZE;
			} //end else if
			
		} //end for
	} //end else
	
	return *top;
} //end pop

//method to print heading
void printHeading() {
	printf("Welcome to Keaton's Stack Program\n"
	"  This program lets you perform various actions"
	"\n  on a stack of floats."
	"\n\n0 > exit"
	"\n1 > push value onto stack"
	"\n2 > pop value off stack");
} //end printHeading
