#include <limits.h>
#include <stdio.h>

#define BIGENDIAN 0
#define LITTLEENDIAN 1

int main()
{
	//64 or 32 bit
	printf("%d bits \n", (int)(CHAR_BIT * sizeof(void *)));
	
	//call to test little or big endian
	int r = TestByteOrder();
	printf("%s\n", r == LITTLEENDIAN ? "Little Endian" : "Big Endian");
	return r;
}

//function to check if little or big endian
int TestByteOrder() {
	short int word = 0x0001;
	char *b = (char *)&word;
	return (b[0] ? LITTLEENDIAN : BIGENDIAN);
}
