package O03Loops;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Defines a class RandomNumbers that generates 
 * 			various random numbers
 * Date modified: 9/17/2019
 */

public class O08RandomNumbers {

	public static void main(String[] args) {
		double randomDouble;
		int randomInt; 

		/*random() returns a double value with a positive sign, greater 
		 *than or equal to 0.0 and less than 1.0.
		 */

		randomDouble = Math.random(); //generate a random number >= 0.0 and < 1.0
		System.out.println ("The system generated " + randomDouble + " randomly");
		System.out.println ("-----------------------------------------"); 

		//generate 10 random numbers between >= to 0.0 and < 1.0
		for (int i=1; i <=10; i++){  
			randomDouble = Math.random(); 
			System.out.println ("The system generated " + randomDouble + " randomly"); 
		}
		System.out.println ("-----------------------------------------"); 


		//generate 10 random numbers >= to 0.0 and < 10.0
		for (int i=1; i <=10; i++){  
			randomDouble = Math.random() * 10; 
			System.out.println ("The system generated " + randomDouble + " randomly"); 
		}
		System.out.println ("-----------------------------------------"); 

		//generate 10 random integers >= 0 and < 10
		for (int i=1; i <=10; i++){  
			randomInt = (int) (Math.random() * 10); 
			System.out.println ("The system generated " + randomInt + " randomly"); 
		}
		System.out.println ("-----------------------------------------"); 

		//generate a random integer between "upper" and "lower"
		int lower=100, upper=120;
		randomDouble =  Math.random();
		System.out.println ("The system generated " + randomDouble);
		randomDouble = randomDouble * (upper-lower);
		System.out.println ("The system generated " + randomDouble);
		randomDouble = lower + randomDouble; 
		System.out.println ("The system generated " + randomDouble);
		randomInt = (int) randomDouble; 
		System.out.println ("The system generated " + randomInt); 
		System.out.println ("-----------------------------------------"); 

		//generate 10 random integers between "upper" and "lower"	    	
		for (int i=1; i <=10; i++){  
			randomInt = (int) (lower + Math.random() * (upper-lower)) ; 
			System.out.println ("The system generated " + randomInt + " randomly"); 
		}

		System.out.println ("-----------------------------------------"); 


	}
}
