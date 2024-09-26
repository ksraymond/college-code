package O05Methods;

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Convert a hexadecimal number to decimal
 * Date modified: 10/17/2019
 */

import java.util.Scanner;

public class O07Hex2Dec {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a hex number: ");
		String hex = input.nextLine();

		input.close();
		System.out.println("The decimal value for hex number " + 
				hex + " is " + hexToDecimal(hex.toUpperCase()));
	}

	public static int hexToDecimal(String hex) {
		int decimalValue = 0;
		for (int i = 0; i < hex.length(); i++) {
			char hexChar = hex.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}

		return decimalValue;
	}

	public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else // ch is '0', '1', ...'9'
			return ch - '0';
	}
}
