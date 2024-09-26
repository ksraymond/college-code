/*Keaton Raymond
CS2060 - 002
Array of String Pointers
Due Date: 4/30/2020
Description: This program will utilize file IO to have the user
	access a file of their choice, print the contents of said file
	provided it exists, if it doesn't exist C will automatically
	create the file, append three strings onto it, then print the 
	contents of the file again. Before each change between read 
	and append what you are doing to the file the file must be 
	closed then reopened.
*/

#include <stdio.h>
#include <stdlib.h>

#define MAX 1024

//prototype
void printHeading(void);

int main(int argc, char * argv[]) {
	
	//initializing file and other needed variables and pointers
	FILE *fPtr = NULL;
	char fileName[50] = "whatever.txt";
	char *line = NULL;
    char *endFile = NULL;
    char name[50] = "whatever";
	char trash = '\0';
	
	//allocating memory for the line variable
	line = (char*)malloc(sizeof(char)* MAX);
	
	//call to function to print the heading
	printHeading();
	
	//asking for name of text file
	printf("Enter the name of the file > ");
	scanf("%s", fileName);
	
	//if the file does not exist, tell the user it did not exist and was made
	if ((fPtr = fopen(fileName,"r"))== NULL)
		printf("%s does not exist and has been created.\n\n", fileName);
	//if file does exist, iterate through file printing it
	else{
		endFile = fgets(line, MAX, fPtr);
		while(endFile != NULL){
			printf("%s", line);
			endFile = fgets(line, MAX, fPtr);
		} //end while
		printf("\nDone Reading.\n\n");
	} //end else
	fclose(fPtr);

	//opening file for appending
	fPtr = fopen(fileName,"a");
	printf("Input three song names > ");
	//for loop asking for user input and adding to the file 3 times
	for(int i=0; i<3; i++) {
		//when i is 0, include the scanf(trash) line
		if(i==0) {
			scanf("%c",&trash);
			fgets(line, MAX, stdin); 
			fprintf(fPtr, "%s", line);
		} //end if
		else {
			fgets(line, MAX, stdin); 
			fprintf(fPtr, "%s", line);
		} //end else
	} //end for
	fclose(fPtr);
	
	//same code for reading and printing file again
	fPtr = fopen(fileName,"r");
	printf("\n%s with your three added strings\n", fileName);
	endFile = fgets(line, MAX, fPtr);
    while(endFile != NULL){
		printf("%s", line);
		endFile = fgets(line, MAX, fPtr);
    } //end while
    printf("\nDone Reading\n\n");
	fclose(fPtr);
	
	//freeing malloc'd memory and return statement
	free(line);
	return 0;
} //end main

//method to print heading
void printHeading() {
	printf("Welcome to Keaton's File IO Program"
	"\n  This program will print the contents of a file,"
	"\n  Let you add three strings to the file,"
	"\n  Then reprint the file with the added strings.\n\n");
} //end printHeading
