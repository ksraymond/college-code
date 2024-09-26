/*Keaton Raymond
CS2060 - 002
Ordered Linked List
Due Date: 4/16/2020
Description: This program will build an ordered linked list
	of numbers greater than 0. When the user inputs 0 or a 
	negative number, the program will exit. The nodes for the
	linked list will be ordered as they are inserted. The header
	node will be global for programmer ease. 
	The program will not:
		have special cases in the insert function for empty
		list or beginning of the list. 
		pass in the header - the header will be global
		have a double linked list, struct will only have 1
		pointer - *next
		use typedef for any reason
		
		honestly i was totally unprepared, behind, and clueless on
		this assignment,i am just turning in what little i have in 
		hopes i can get some level of partial credit
*/

#include <stdio.h>
#include <stdlib.h>

void printHeading();

//listNode structure declaration
struct listNode {
    int data;           //ordered field
    struct listNode *next;
};

//global header node
struct listNode header = {0, NULL};

int main(int argc, char * argv[]) {
	
	//declare variables
	int input = 0;
	
	//call to function to print heading
	printHeading();
	
	do {
		printf("Enter a number > ");
		scanf("%d", &input);
		
		if(input > 0) {
			createNode(input);
		}
		
	} while(input > 0);
	
	//print list
	//free list
	//exit
	
	return 0;
}

void createNode(int inputPtr) {
	header = insertNode(inputPtr);
	
}

listNode insertNode(int inputPtr) {
	return listNode a = { inputPtr, NULL};
}

void printList() {
	
}

void freeList() {
	
}

//method to print heading
void printHeading() {
	printf("Welcome to Keaton's Ordered Linked List\n"
	"  This program lets you input positive values"
	" into an ordered linked list."
	"\n  Input 0 or a negative number to end.\n\n");
} //end printHeading
