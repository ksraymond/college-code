// Shorter! cube a variable using call by reference
// Sorry this is missing documentation and a resonable
// user interface.

#include <stdio.h>

void cubeByReference (int *, int *);

main ( )
{
	int ans = 0;
	int number = 5;		//both local to main
	
	cubeByReference (&number, &ans);
	printf("%d cubed = %d", number, ans);
}

void cubeByReference ( int * numPt, int *answer)
{//cubes value numPt points to, stores where answer points

	*answer =  (*numPt) * (*numPt) * (*numPt);
}
