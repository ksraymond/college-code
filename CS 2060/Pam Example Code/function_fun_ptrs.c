# include <stdio.h>

int fun(char);
int funny(char);
int funnier(char);

int main(int argc, char * argv[]){
	
	char b = '\0';
	int ans = 0;

	int (*funn[])(char bar)={ fun, funny, funnier	};
	
	for(int i = 0; i <=2; i++){
		ans = (funn[i])(b);
		printf("%d\n", ans);
	}

	return 0;
}

int fun(char b){
//not a whole lot

	printf("I am fun.  ");
	return 9;
}

int funny(char c){
//even less than fun()
	
	printf("I am funny.  ");
	return 99;
}

int funnier(char b){
// the best of all
	
	printf("I am funnier.  ");
	return 666;
}
