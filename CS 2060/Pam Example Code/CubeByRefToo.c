//cube by reference
#include <stdio.h>

void cubeByReference (int *);	//NOTE: no value returned!!

void main ( )
{
	int number = 0;		//local to main( )
	int * numPtr = NULL;

	numPtr = &number;

	//print welcome, program purpose, and get value to cube
	printf("Welcome to Pam\'s Cube Numbers Program\n");
	printf("This program cubes integer values.\n\n");
	printf("  input whole number to cube > ");
	scanf("%d", &number);
	
	//print result
	printf ( "\n   %d", number  );
	cubeByReference ( numPtr );
	printf ( " cubed is %d \n", number );

}

void cubeByReference (int *nPtr)
{
	int num = 0;
	
	num = *nPtr;
	num = ( num ) * (  num ) * ( num );		//cube the number
	
	//store the result into the memory address
	//held by nPtr
	*nPtr = num;
}

