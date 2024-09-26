package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 5
 *Due: 2/26/2020
 *Description: This program will read values from 2 files of integers and strings,
 *			   place them into stacks, print the sorted stacks,
 *			   combine, sort and print the stacks, and finally print both merged
 *			   stacks side by side
 */

public class RaymondKeatonAssignment5 {
	public static void main(String[] args) throws IOException{

		//opening and reading files
		File numFile1 = new File("numbers1.txt");
		File numFile2 = new File("numbers2.txt");
		File strFile1 = new File("mountains1.txt");
		File strFile2 = new File("mountains2.txt");
		Scanner readNum1 = new Scanner(numFile1);
		Scanner readNum2 = new Scanner(numFile2);
		Scanner readStr1 = new Scanner(strFile1);
		Scanner readStr2 = new Scanner(strFile2);

		//constructors for each stack
		GenericStack<Integer> numStack1 = new GenericStack<>();
		GenericStack<Integer> numStack2 = new GenericStack<>();
		GenericStack<Integer> mergeNumStack = new GenericStack<>();
		GenericStack<Integer> reverseNumStack = new GenericStack<>();

		GenericStack<String> strStack1 = new GenericStack<>();
		GenericStack<String> strStack2 = new GenericStack<>();
		GenericStack<String> mergeStrStack = new GenericStack<>();
		GenericStack<String> reverseStrStack = new GenericStack<>();

		//while loops populating each stack
		while(readNum1.hasNext())
			numStack1.push(readNum1.nextInt());
		while(readNum2.hasNext())
			numStack2.push(readNum2.nextInt());
		while(readStr1.hasNext())
			strStack1.push(readStr1.nextLine());
		while(readStr2.hasNext())
			strStack2.push(readStr2.nextLine());

		//printing contents of numStack1
		System.out.println("Numbers Stack 1 - filled with values from numbers1.txt");
		System.out.println("-------------------------------------------------------");
		printStack(numStack1);

		//printing contents of numStack2
		System.out.println("\nNumbers Stack 2 - filled with values from numbers2.txt");
		System.out.println("-------------------------------------------------------");
		printStack(numStack2);

		//printing merged num stack
		System.out.println("\nMerged Stack - lowest value on top");
		System.out.println("-----------------------------------");
		mergeStacks(numStack1, numStack2, mergeNumStack);
		reverseStack(mergeNumStack, reverseNumStack);
		printStack(reverseNumStack);

		//printing contents of strStack1
		System.out.println("\nString Stack 1 - filled with values from mountains1.txt");
		System.out.println("-------------------------------------------------------");
		printStack(strStack1);

		//printing contents of strStack2
		System.out.println("\nString Stack 2 - filled with values from mountains2.txt");
		System.out.println("-------------------------------------------------------");
		printStack(strStack2);

		//printing merged string stack
		System.out.println("\nMerged Stack - lowest value on top");
		System.out.println("-----------------------------------");
		mergeStacks(strStack1, strStack2, mergeStrStack);
		reverseStack(mergeStrStack, reverseStrStack);
		printStack(reverseStrStack);

		//printing both stacks side by side
		System.out.println("\nPrinting Merged Stacks side by side - lowest value on top");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Integers\tStrings");
		System.out.println("-------------------------------------------------------------");
		printTwoStacks(reverseNumStack, reverseStrStack);

		//close the files
		readNum1.close();
		readNum2.close();
		readStr1.close();
		readStr2.close();

	} //end main method

	//method to print a stack
	public static <E> void printStack(GenericStack<E> stack) {
		ArrayList<E> holdStack = new ArrayList<>();
		int size = stack.getSize();

		//print each value and "pop" it off the stack
		for(int i=0; i<size; i++) {
			System.out.println(stack.peek());
			holdStack.add(stack.peek());
			stack.pop();
		} //end for

		int index = (holdStack.size()-1);
		//for loop to reset the stack to the original order using the ArrayList above
		for(int i=index; i>=0; i--) {
			stack.push(holdStack.get(i));
		} //end for
	} //end printStack

	//method to merge the two stacks
	public static <E extends Comparable<E>> void mergeStacks
	(GenericStack<E> stack1, GenericStack<E> stack2, GenericStack<E> mergedStack) {

		//while neither is empty, check both stacks
		while(!(stack1.isEmpty() || stack2.isEmpty())) {

			//if stack1's value is less than stack2's, insert stack1's value
			if(stack1.peek().compareTo(stack2.peek()) <= -1) {
				mergedStack.push(stack1.peek());
				stack1.pop();
			} //end if
			
			//if stack2's value is less than stack1's, insert stack2's value
			else if(stack1.peek().compareTo(stack2.peek()) >= 1) {
				mergedStack.push(stack2.peek());
				stack2.pop();
			} //end else if
			
			//if equal, insert either value (I chose from stack 1)
			else {
				mergedStack.push(stack1.peek());
				stack1.pop();
			} //end else
			
		} //end while

		//if stack1 is empty, only print stack2
		if(stack1.isEmpty()) {
			while(!(stack2.isEmpty())) {
				mergedStack.push(stack2.peek());
				stack2.pop();
			} //end while
		} //end if
		
		//if stack2 is empty, only print stack1
		else {
			while(!(stack1.isEmpty())) {
				mergedStack.push(stack1.peek());
				stack1.pop();
			} //end while
		} //end else
		
	} //end mergeStacks

	//method to reverse the variables in the stack
	public static <E> void reverseStack(GenericStack<E> stack, GenericStack<E> finalMergedStack) {
		int size = stack.getSize();
		for(int i=0; i<size; i++) {
			finalMergedStack.push(stack.peek());
			stack.pop();
		} //end for
	} //end reverseStack

	//method to print both stacks side by side
	public static <E, F> void printTwoStacks(GenericStack<E> stack1, GenericStack<F> stack2) {
		//used at end of the method
		E topNum = stack1.peek();
		F topStr = stack2.peek();
		
		//while neither stack is empty, print values in correct format
		while(!(stack1.isEmpty() || stack2.isEmpty())) {
			System.out.printf("%s\t\t%s\n", stack1.peek(), stack2.peek());
			stack1.pop();
			stack2.pop();
		} //end while
		
		//if strStack is empty, continue printing numStack
		if(stack2.isEmpty()) {
			while(!(stack1.isEmpty())) {
				System.out.printf("%s\t\t----", stack1.peek());
				stack1.pop();
			} //end while
		}//end if
		
		//if numStack is empty, continue printing strStack
		else {
			while(!(stack2.isEmpty())) {
				System.out.printf("----\t\t%s", stack2.peek());
				stack2.pop();
			} //end while
		} //end else
		
		//print the top values of each stack using values grabbed at top of method
		System.out.printf("\n\nNumber stack top: %s\n"
				+ "String stack top: %s", topNum, topStr);
	} //end printTwoStacks

} //end main class

//class for the generic stack
class GenericStack<E>{
	private ArrayList<E> list = new ArrayList<>();

	//GenericStack constructor
	public GenericStack() {
	}

	//returns size of the stack
	public int getSize() {
		return list.size();
	}
	
	//returns whether or not the stack is empty
	public boolean isEmpty() {
		if(list.isEmpty())
			return true;
		else
			return false;
	}
	
	//returns the value at the "top" of the stack
	public E peek() {
		return list.get(list.size()-1);
	}
	
	//adds a value to the "top" of the stack
	public void push(E E) {
		list.add(E);
	}
	
	//removes a value from the "top" of the stack
	public void pop() {
		list.remove(list.size()-1);
	}

} //end class GenericStack