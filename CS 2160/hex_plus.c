//Keaton Raymond
//CS 2160 - 001
//add 2 inputted 4 bit hex strings
 
#include <stdio.h>

//prototypes
int getNum(char ch);
unsigned int hex2int(unsigned char hex[]);
void int2hex(unsigned int decimalnum);
 
//function to get the decimal value from each individual hex character
int getNum(char ch)
{
    int num=0;
    if(ch>='0' && ch<='9')
        num=ch-0x30;
    else
    {
        switch(ch)
        {
            case 'A': case 'a': num=10; break;
            case 'B': case 'b': num=11; break;
            case 'C': case 'c': num=12; break;
            case 'D': case 'd': num=13; break;
            case 'E': case 'e': num=14; break;
            case 'F': case 'f': num=15; break;
            default: num=0;
        } //end switch
    } //end else
    return num;
} //end getNum

//function to go through the arithmetic of converting a 4 bit
//hex number to decimal
unsigned int hex2int(unsigned char hex[])
{
	//declaring variables for the result and each bit
    unsigned int result=0;
    unsigned int first=0;
    unsigned int second=0;
    unsigned int third=0;
    unsigned int fourth=0;
    
    //converting each individual bit
    first=(getNum(hex[0]))*(16*16*16);
    second=(getNum(hex[1]))*(16*16);
    third=(getNum(hex[2]))*16;
    fourth=getNum(hex[3]);
    
    //adding bits together
    result=first+second+third+fourth;
} //end hex2int

//function to convert int to hex and print the result
void int2hex(unsigned int decimalnum)
{
	//declaring variables needed for conversion
	int quotient=0;
	int remainder=0;
	int j=0;
	int i=0;
	char hexnum[10];
	
	quotient=decimalnum;
	
	//conversion loop
	while(quotient != 0)
	{
		remainder = quotient % 16;
		if (remainder < 10)
			hexnum[j++]=48+remainder;
		else
			hexnum[j++]=55+remainder;
		quotient=quotient/16;
	} //end while
	
	//print result
	printf("Summation: 0x");
	for (i=j-1; i>=0; i--) {
		printf("%c", hexnum[i]);}
} //end int2hex

int main()
{
	//declaring variables for the 2 inputted hex values
    unsigned char hexValue1[4];
    unsigned char hexValue2[4];
    unsigned int  intValue1=0;
    unsigned int intValue2=0;
    
    //getting inputs
    printf("Enter First 4 bit Hex String: ");
    scanf("%s", hexValue1);
    printf("Enter Second 4 Bit Hex String: ");
    scanf("%s", hexValue2);
 
	//call to convert each hex to decimal
    intValue1=hex2int(hexValue1);
    intValue2=hex2int(hexValue2);
    
    //add the two decimal conversions and convert back
    int2hex(intValue1+intValue2);
     
    return 0;
} //end main
