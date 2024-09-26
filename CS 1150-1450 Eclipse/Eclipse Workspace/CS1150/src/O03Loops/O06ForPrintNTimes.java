package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class that prints a sentence for many times
 * Date modified: 9/17/2019
 */

public class O06ForPrintNTimes {
	public static void main (String[] args){

		//declare a running counter for the loop
		//int i;
		//declare a total number of times for the loop
		int times;

		//assign how many times
		times = 10;  //change times to 0, -20, 1000, etc. 
		
		//A very simple for loop 
		for (int i = 1 ; i < times; i = i+1){
			if (i==1) {
				System.out.println ("For the " + i + "st time: I didn't do my homework!");	
			}else if (i==2) {
				System.out.println ("For the " + i + "nd time: I didn't do my homework!");	
			}else if (i==3) {
				System.out.println ("For the " + i + "rd time: I didn't do my homework!");	
			}else {
				System.out.println ("For the " + i + "th time: I didn't do my homework!");
			} 
		}

		//System.out.println("After for i is " + i);	

		/*int i; 
		for (i=0; i<10; i++){
			System.out.println("i is " + i);
		}
		System.out.println("After for i is " + i);
		*/
		
	}

}
