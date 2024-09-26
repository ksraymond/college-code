#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>


struct myStruct{
	
	char * a;
	float e;
	int c;
	short h;
	char b;
	
	
	
	
	
	
	
	
	
	
	
	
	
} myStruct;

int main(int argc, char * argv[]) {
	
	printf("sizeof(struct myStruct) = %ld\n", (long) sizeof(struct myStruct));
	
	printf("offset of a = %ld\n", (long) offsetof(struct myStruct, a));
	printf("offset of b = %ld\n", (long) offsetof(struct myStruct, b));
	printf("offset of h = %ld\n", (long) offsetof(struct myStruct, h));
	printf("offset of c = %ld\n", (long) offsetof(struct myStruct, c));
	printf("offset of e = %ld\n", (long) offsetof(struct myStruct, e));
	
	return 0;
}
