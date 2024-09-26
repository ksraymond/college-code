/*Keaton Raymond
CS2060 - 002
Pass by Reference Assignment 1
Due Date: 2/21/2020
Description: This program will convert Celsius to Farenheit
	in 10 degree increments. The user inputs the the lower
	and upper Celsius values. The values are converted in
	10 degree increments starting with the lower value and
	ending with either the upper value or the last value 
	less than that value within a 10 degree step.
	Should only have local varaibles, and use pass by ref
	to pass Celsius and Farenheit into conversion function.
*/

#include <stdio.h>

//prototypes
void printHeading();
void convertByRef(float* lowerC, float* farenheit);

int main(int argc, char * argv[]) {
	
	//initializing variables
	float lowerC = 0;
	float upperC = 0;
	float farenheit = 0;
	float holdC = 0;  //used if lowerC > upperC
	
	//call on a function to print the heading
	printHeading();
	
	//taking two Celsius inputs
	printf("Enter lower celsius value > ");
	scanf("%f", &lowerC);
	printf("Enter upper celsius value > ");
	scanf("%f", &upperC);
	
	//if lowerC > upperC, swap two values
	if(lowerC > upperC) {
		holdC = lowerC;
		lowerC = upperC;
		upperC = holdC;
	}
	
	//printing heading before conversions
	printf("\n Celsius               Farenheit\n"
			" ----------------------------------\n");
	
	//while loop printing each conversion
	while(lowerC <= upperC) {
		//call to conversion method
		convertByRef(&lowerC, &farenheit);
		printf("%5.0f%24.2f\n", lowerC, farenheit);
		lowerC += 10;
	} //end while
	
} //end main

//method to print the heading to make main look cleaner
void printHeading() {
	printf("Welcome to Keaton's Celsius to Farenheit converter\n"
	"  This program asks for lower and upper Celsius values."
	"\n	Then prints a table with the"
	"\n	Celsius values in increments of 10 degrees and"
	"\n	the Farenheit conversions.\n\n");
} //end printHeading

//conversion method using pointers
void convertByRef(float* lowerCPt, float* farenheitPt) {
	*farenheitPt = (((*lowerCPt)*1.8) + 32);
}
