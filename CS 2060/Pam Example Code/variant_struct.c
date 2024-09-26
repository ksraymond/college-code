//Variant Structures


#include <stdio.h>

struct figure{
	float area, perimeter;	//common components
	
	//int type;  	//replace with enum - Active Component Tag
					// could use with 	  #define 	CIRCLE  0
										//#define RECTANGLE 1...
	enum {circle, 	
		rectangle, 
		triangle	//Active Component Tag
	} type;			//since there is no tag, type is the ONLY instance
	
	union{
		float radius;		//circle
		int sides[2];		//rectangle
		float triSide[3];	//triangle
	} dimensions;			//variable name for this component

} my_figure = { 0, 0, circle};

int main(int argc, char * argv[]){
	
	my_figure.dimensions.radius = 1;
	printf(" area = %.2f\n perimeter = %.2f\n type = %d\n %.2f\n ",my_figure.area, my_figure.perimeter,my_figure.type, my_figure.dimensions.radius);
	
	return 0;
}
