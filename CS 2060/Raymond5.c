/*Keaton Raymond
CS2060 - 002
Array of String Pointers
Due Date: 4/30/2020
Description: This program will implement an array of string
	pointers. It will print the array, sort the array, then
	print the sorted array. The sorting algorithm will be a
	bubble sort as opposed to using strcmp function. There
	will be two functions in addition to main, one to print
	the array using a for loop, and another to sort the array
	and call to the print function to print the sorted array.
*/

#include <stdio.h>
#include <stdlib.h>

//prototypes
void printHeading(void);
void printList(char *wordPtr[], int size);
void sortList(char *wordPtr[], int size);

int main(int argc, char * argv[]) {
	//creating the array and a variable to hold the size
	char *wordPtr[] = {"Eric","Andrew","Sean","Daniel"};
	int size = 0;
	size = sizeof(wordPtr)/sizeof(char*);
	
	//call to the function to print the heading
	printHeading();
	
	//call to function to print the unsorted list
	printf("Unsorted list\n");
	printList(wordPtr, size);
	
	//call to funciton to sort and print the list
	printf("\nSorted list\n");
	sortList(wordPtr, size);
	
	
	return 0;
}

//method with for loop to print the list
void printList(char *wordPtr[], int size) {
	for(int i=0; i < size; i++) {
		printf("%s\n", wordPtr[i]);
	}
} //end printList

//method to bubble sort the list
void sortList(char *wordPtr[], int size) {
	char* tempPtr[size]; //new array to hold the sorted array
	
	//bubble sort
	for(int j=0; j < size-1; j++) {
		for(int i=0; i < size-1; i++) {
			if(*wordPtr[i] > *wordPtr[i+1]){
				tempPtr[i] = wordPtr[i+1];
				tempPtr[i+1] = wordPtr[i];
			} //end if
			else{
				tempPtr[i] = wordPtr[i];
				tempPtr[i+1] = wordPtr[i+1];
			} //end else
			
		} //end inner for
	} //end outside for
	
	//call to printList function to print sorted list
	printList(tempPtr, size);
} //end sortList

//method to print heading
void printHeading() {
	printf("Welcome to Keaton's String Pointer Program"
	"\n  This program will print an array of strings."
	"\n  And will then sort and reprint the array.\n\n");
} //end printHeading
