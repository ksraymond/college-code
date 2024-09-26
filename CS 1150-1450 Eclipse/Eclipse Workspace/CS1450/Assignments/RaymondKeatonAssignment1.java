package Assignments;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 1
 *Due: 1/29/2020
 *Description: this program will create two random size arrays (1-10) and fill them with random ints 1-25
 *			   sort the arrays and display the sorted version
 *			   write the sorted arrays to a file and display each value as it is written
 *			   put both sorted arrays into one array, remove duplicate numbers, and display the sorted array
 */


public class RaymondKeatonAssignment1 {
	public static void main(String args[]) throws IOException {

		//making all needed arrays and variables
		int size1 = (int)(1+Math.random()*10);
		int size2 = (int)(1+Math.random()*10);
		int[] array1 = new int[size1];
		int[] array2 = new int[size2];
		int fileSize = size1+size2;
		int[] fileArray = new int[fileSize];
		int fixedSize = 0;

		System.out.printf("Size1 = %d\nSize2 = %d\n", size1, size2);	//printing sizes of two arrays

		//assigning random values from 1-25 to the arrays
		for(int i=0; i<array1.length; i++)
			array1[i] = (int)(1+Math.random()*25);
		for(int i=0; i<array2.length; i++)
			array2[i] = (int)(1+Math.random()*25);

		//sorting the two arrays using the arrays library
		Arrays.sort(array1);
		Arrays.sort(array2);

		//printing values of first array
		System.out.printf("\nFirst array with %d sorted random values\n", size1);
		System.out.println("---------------------------------------");
		for(int i=0; i<array1.length; i++)
			System.out.println(array1[i]);

		//printing values of second array
		System.out.printf("\nSecond array with %d sorted random values\n", size2);
		System.out.println("---------------------------------------");
		for(int i=0; i<array2.length; i++)
			System.out.println(array2[i]);


		//setting up the file
		File fileName = new File("assignment1.txt");
		PrintWriter resultsFile = new PrintWriter (fileName);

		System.out.println("\nWriting values to the file\n"
				+ "---------------------------------------");
		
		int index1=0;
		int index2=0;
		
		while(index1 != size1 && index2 != size2) {
			if(array1[index1] <= array2[index2]) {
				resultsFile.println(array1[index1]);
				System.out.printf("Writing: %d\n", array1[index1]);
				index1++;
			} //end if
			else {
				resultsFile.println(array2[index2]);
				System.out.printf("Writing: %d\n", array2[index2]);
				index2++;
			} //end else
		} //end index1 and 2 while
		
		while(index1 < size1) {
			resultsFile.println(array1[index1]);
			System.out.printf("Writing: %d\n", array1[index1]);
			index1++;
		} //end index1 while
		
		while(index2 < size2) {
			resultsFile.println(array2[index2]);
			System.out.printf("Writing: %d\n", array2[index2]);
			index2++;
		} //end index2 while
		
		resultsFile.close();
		
		//reopening the file for reading
		Scanner inputFile = new Scanner (fileName);
		
		//turning duplicate numbers into 0s
		for(int i=0; i<fileArray.length; i++) {
			fileArray[i] = inputFile.nextInt();
			if(i>=1 && (fileArray[i] == fileArray[i-1]))
				fileArray[i-1] = 0;
			if(fileArray[i] != 0)
				fixedSize++;
		} //end for
		
		inputFile.close(); //closing the file

		System.out.println("\nArray with no duplicate values\n"
				+ "---------------------------------------");
		
		//sorting out the 0s inserted in place of duplicates and printing the new array
		int[] fixedArray = new int[fixedSize];
		for(int i=0, j=0; i<fileArray.length && j<fixedArray.length; i++) {
			if(fileArray[i] != 0) {
				fixedArray[j] = fileArray[i];
				System.out.println(fixedArray[j]);
				j++;
			} //end if
		} //end for
		
	} //end main
} //end class