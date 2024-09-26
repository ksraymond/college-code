#include<stdio.h>

//Keaton Raymond
//CS 2160 - 002
//Homework 2

int func1(int a, int b) {
	printf("executing func1\n");
	int answer = 0;
	answer = (2+a)+(a*2);
	answer = answer + b*4;
	answer = answer*a;
	printf("func1 returns: %d\n", answer);
	return answer;
}

int func2(int a, int b) {
	printf("executing func2\n");
	int answer = 0;
	if(a>0) {
		b >> 1;
		a -= 4;
		while(a>0) {
			b >> 1;
			a -= 4;
		}
	}
	answer = b;
	printf("func2 returns: %d\n", answer);
	return answer;
}

int func3(int a, int b) {
	printf("executing func3\n");
	int answer=0;
	if(a>0) {
		if(b>4) {
			answer=1;
		}
		else {
			answer=0;
		}
		answer = -1+answer+(1*answer);
	}
	else {
		answer=0xffffffff;
	}
	printf("func3 returns: %d\n", answer);
}

int func4(int a, int b) {
	printf("executing func4\n");
	char answer = getchar();
	answer = answer & 0xf5;
	answer = (0x34 == answer);
	return answer;
}

int main() {
	int a;
	int b = 20;

	printf("make the variable a equals to:\n");
	scanf("%d\n", &a);

	func1(a,b);
	func2(a,b);
	func3(a,b);

	printf("func4 returns: %d\n", func4(a,b));
	return 0;
}
