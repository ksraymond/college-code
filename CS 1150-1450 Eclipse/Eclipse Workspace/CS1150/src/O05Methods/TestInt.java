package O05Methods;

import java.util.Scanner;

public class TestInt {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer");
		int number = input.nextInt();
		input.close();
		
		if(isEven(number) == true)
			System.out.println(number + " is even");
		else
			System.out.println(number + " is odd");
		
		if(isPrime(number) == true)
			System.out.println(number + " is prime");
		else
			System.out.println(number + " is not prime");
		
	}
	
	public static boolean isEven(int number) {
		if(number % 2 == 0) 
			return true;
		else 
			return false;
	}
	
	public static boolean isPrime(int number) {
		int i;
		boolean isPrime = true;
		for(i=2; i < number; i++) {
			if(number % i == 0) {
				isPrime = false;
			}
		}
		return isPrime;
	}

}
