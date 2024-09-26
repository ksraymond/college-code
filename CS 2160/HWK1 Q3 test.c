#include <stdio.h>

#define NUM 'CBA'

int main() {
	int a = NUM;
	char * pt = (char *) &a;
	
	printf("a is: %d\n", a);
	printf("string is: %s\n", pt);
	return 0;
}
