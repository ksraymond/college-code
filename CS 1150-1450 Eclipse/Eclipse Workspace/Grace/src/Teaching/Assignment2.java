package Teaching;

import java.util.Scanner;

/* requirements
 * name of applicant
 * ask for percentage of down payment (double)
 * if percentage is not minimum 15%, reject
 * if customer can put 15% or more, ask for credit score (int)
 * if credit score is less than 500, reject
 * if greater than or equal to 500, approve
 */

public class Assignment2 {

	public static void main(String args[]) {
		
		//declaring variables
		String name;
		double downPayment;
		int credit;
		
		//opening keyboard
		Scanner input = new Scanner(System.in);
		
		//asking for name
		System.out.print("Enter your name: ");
		name = input.nextLine();
		
		//asking for down payment
		System.out.printf("%s, Enter the percentage of your down payment: ", name);
		downPayment = input.nextDouble();
		
		//if downpayment is >= 15%, continue
		if(downPayment >= 15) {	
			//ask for credit score
			System.out.printf("%s, enter your credit score: ", name);
			credit = input.nextInt();
			
			//if credit score is >= 500, approve. else reject
			if(credit >= 500)
				System.out.printf("%s, your application has been approved.", name);
			else
				System.out.printf("Sorry %s, but your application is being rejected", name);
		} //end if downpayment
		
		//if downpayment is < 15%, reject
		else
			System.out.printf("Sorry %s, but your application is being rejected.", name);
		
		//closing keyboard
		input.close();
	} //end main
} //end class
