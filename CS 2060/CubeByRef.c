//pass value to cube by reference

#include <stdio.h>

int cubeByValue(int valueToCube); //prototype
void cubeByRef(int * valuePtr);
void cubeByRefToo(int* answerPt, int* valuePt);

int main(int argc, char * argv[]) {
	
	int value = 0;
	int answer = 0;
	
	//initialize value
	value = 5;
	
	//cube and print result
	answer = cubeByValue(value);
	printf("%d cubed (by value) is %d\n", value, answer);
	
	//cube and print result using pass by reference
	printf("%d cubed (by reference) is ", value);
	cubeByRef(&value);
	printf("%d\n", value);
	
	//reset value b/c last pass by ref changed value
	value = 5;
	
	//cube and print result using pass by reference
	cubeByRefToo(&answer, &value);
	printf("%d cubed (by reference again) is %d\n", value, answer);
	
} //end main


int cubeByValue(int valueToCube) {
//cubes passed in value and returns the cube

	return valueToCube*valueToCube*valueToCube;

} //end cubeByValue

void cubeByRef(int* valuePtr){
//cubes passed value stored in address that is passed in
//passes NOTHING back

	*valuePtr = (*valuePtr)*(*valuePtr)*(*valuePtr);

} //end cubeByRef

void cubeByRefToo(int* answerPt, int* valuePt) {
//cube passed in value stored in address that is passed in
//stores result in second passed in pointer - answer

	*answerPt = (*valuePt)*(*valuePt)*(*valuePt);

} //end cubeByRefToo
