package O02Booleans;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Testing if a rectangle is inside of another
 * Date modified: 9/6/2019
 */

import java.util.Scanner;


public class O09Is1RectangleInsideAnother{
	public static void main (String[] args){
		Scanner keyboard;
		keyboard = new Scanner (System.in);

		double x1, y1, h1, w1, x2, y2, h2, w2;
		double r1left, r1right, r1low, r1high;
		double r2left, r2right, r2low, r2high;
		boolean is1Inside2, does1Overlap2; 

		System.out.println ("Input center point's x and y coordinates for first rectangle: ");
		x1 = keyboard.nextDouble();
		y1 = keyboard.nextDouble();
		System.out.println ("x1 = " + x1 + " y1 = " + y1);
		System.out.println ("Input first rectangle's height and width: ");
		h1 = keyboard.nextDouble();
		w1 = keyboard.nextDouble();
		System.out.println ("h1 = " + h1 + " w1 = " + w1);

		System.out.println ("Input center point's x and y coordinates for second rectangle: ");
		x2 = keyboard.nextDouble();
		y2 = keyboard.nextDouble();
		System.out.println ("x2 = " + x2 + " y2 = " + y2);
		System.out.println ("Input second rectangle's height and width: ");
		h2 = keyboard.nextDouble();
		w2 = keyboard.nextDouble();
		System.out.println ("h2 = " + h2 + " w2 = " + w2);

		keyboard.close();

		r1left = x1 - w1/2;
		r1right = x1 + w1/2;
		r1low = y1 - h1/2;
		r1high = y1 + h1/2;
		System.out.println ("r1left = " + r1left + " r1right = " + r1right +
				" r1low = " + r1low + " r1high = " + r1high);	

		r2left = x2 - w2/2;
		r2right = x2 + w2/2;
		r2low = y2 - h2/2;
		r2high = y2 + h2/2;
		System.out.println ("r2left = " + r2left + " r2right = " + r2right +
				" r2low = " + r2low + " r2high = " + r2high);	

		if ((r1left  < r2left) && (r1right > r2right) && (r1high > r2high) && (r1low < r2low) )
		{
			System.out.println ("Rectangle 1 includes Rectangle 2");
			is1Inside2 = true; 
		}
		else{
			is1Inside2 = false;
		}

		if ((r1left > r2right) || (r1right < r2left) || (r1high <r2low) || (r1low > r2high))
		{
			System.out.println ("Rectangles 1 and 2 do not overlap");
			does1Overlap2 = false; 
		}
		else {
			System.out.println ("Rectangls 1 and 2 overlap");
			does1Overlap2 = true; 
		}


	}

}
