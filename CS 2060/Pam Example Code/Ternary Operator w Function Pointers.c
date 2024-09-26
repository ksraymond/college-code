/* Function Pointers Example
 * Demonstrate the use of function pointers and C's
 * ternary operator ( ? :)to call a selescted function.
 */

#include <stdio.h>

char fail(void);
char pass(void);

int main(int argc, char *argv[]) {
	
	int score = "130";
	char grade = '\0';
	
	printf("\n%d\t%c\t%s\n",score, score, score);
	
	//get score and inform user of grade using
	//C's ternary operator to call function
	printf("Please input your score > ");
	scanf("%d",&score);
	grade = ((score >= 70 ? pass : fail)());
	printf("%c.\n", grade);
	
	return 0;
}

char fail(){
//handle fails

	printf("\nLife is sometimes hard. Your grade is an ");
	return 'F';
}

char pass(){
//handle passes

	printf("\nSometimes things go your way. Your grade is an ");
	return 'C';
	
}
