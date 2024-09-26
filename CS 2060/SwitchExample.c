//

#include <stdio.h>

int main(int argc, char ** argv[]) {
	
	char initial = 'A';

	switch (initial){
		case 'A':	printf("\nI am an A\n");
					break;
		case 'B':
		case 'C':
					printf("\nI am a B or a C\n");
					break;
		default:	printf("\nI am not A, B, or C\n");
	} //end switch
} //end main
