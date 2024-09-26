package Assignments;

import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 7
 *Due: 4/15/2020
 *Description:  This program will read data from four different files to create 2 crosswords
 *				two of which are the locations of where characters will be, the other two
 *				contain the characters themselves. Each crossword will be a 2D array, one
 *				will be implemented through the use of an ArrayList, the other through a
 *				Queue. Each crossword will implement Iterators to read through the ArrayList
 *				and Queue that contains the characters in the crossword. The program will
 *				then print each 2D array.
 */

public class RaymondKeatonAssignment8{

	public static void main(String args[]) throws IOException{
		
		//files and scanners for the four files
		File listLetter = new File("listLetters.txt");
		File listSlot = new File("listSlots.txt");
		File queueLetter = new File("queueLetters.txt");
		File queueSlot = new File("queueSlots.txt");
		Scanner listLetters = new Scanner(listLetter);
		Scanner listSlots = new Scanner(listSlot);
		Scanner queueLetters = new Scanner(queueLetter);
		Scanner queueSlots = new Scanner(queueSlot);

		//ArrayLists and Queues for each respective file and crossword
		ArrayList<Character> lettersList = new ArrayList<>();
		ArrayList<Slot> slotsList = new ArrayList<>();
		Queue<Character> lettersQueue = new LinkedList<>();
		Queue<Slot> slotsQueue = new LinkedList<>();

		//before reading through files, getting the numbers that define the size of each array
		int listRow, listCol, queueRow, queueCol;
		listRow = listSlots.nextInt();
		listCol = listSlots.nextInt();
		queueRow = queueSlots.nextInt();
		queueCol = queueSlots.nextInt();
		
		//while loops reading through each of the four files, placing each value into the respective collection
		while(listLetters.hasNext()) {
			lettersList.add(listLetters.next().charAt(0));
		}
		while(listSlots.hasNext()) {
			slotsList.add(new Slot(listSlots.nextInt(), listSlots.nextInt()));
		}
		while(queueLetters.hasNext()) {
			lettersQueue.offer(queueLetters.next().charAt(0));
		}
		while(queueSlots.hasNext()) {
			slotsQueue.offer(new Slot(queueSlots.nextInt(), queueSlots.nextInt()));
		}
		
		//constructors for the two crosswords
		Crossword listCrossword = new Crossword(listRow, listCol);
		Crossword queueCrossword = new Crossword(queueRow, queueCol);
		
		//creating iterators for each ArrayList/queue
		Iterator<Character> lettersListIterator = lettersList.iterator();
		Iterator<Slot> slotsListIterator = slotsList.iterator();
		Iterator<Character> lettersQueueIterator = lettersQueue.iterator();
		Iterator<Slot> slotsQueueIterator = slotsQueue.iterator();
		
		//calling the enterLetters method for each crossword to enter the letters into the crossword
		listCrossword.enterLetters(lettersListIterator, slotsListIterator);
		queueCrossword.enterLetters(lettersQueueIterator, slotsQueueIterator);
		
		//formatting and printing each crossword
		System.out.println("***************");
		System.out.println("Crossword #1");
		System.out.println("***************");
		listCrossword.printCrossword();
		System.out.println("\n\n***************");
		System.out.println("Crossword #2");
		System.out.println("***************");
		queueCrossword.printCrossword();

		//closing the four files
		listLetters.close();
		listSlots.close();
		queueLetters.close();
		queueSlots.close();
	} //end main method
} //end main class

//class "reserving" each slot that is going to have a character in it
class Slot {
	private int row, column;

	//slot constructor
	public Slot(int row, int column) {
		this.row = row;
		this.column = column;
	} //end slot constructor

	//getters for the row and column
	public int getRow() {
		return row;
	} //end getRow
	public int getColumn() {
		return column;
	} //end getColumn
} //end slot class

//class for the crossword
class Crossword {
	private Character[][] puzzleArray;
	private int numRows, numCols;
	private final Character EMPTY_CHARACTER = '_';

	//crossword constructor
	public Crossword(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		puzzleArray = new Character[numRows][numCols];

		//filling crossword with '_'
		for(int row = 0; row < numRows; row++) {
			for(int column = 0; column < numCols; column++) {
				puzzleArray[row][column] = EMPTY_CHARACTER;
			} //end for column
		} //end for row
	} //end constructor

	//method to iterate through each collection adding each character to the crossword
	public void enterLetters (Iterator<Character> letterIterator, Iterator<Slot> slotIterator) {
		while(letterIterator.hasNext() && slotIterator.hasNext()) {
			 Slot holdSlot = slotIterator.next();
			 puzzleArray[holdSlot.getRow()][holdSlot.getColumn()] = letterIterator.next();
		} //end while
	} //end enterLetters

	//method to print the 2D array for the crossword
	public void printCrossword() {
		for(int row = 0; row < numRows; row++) {
			System.out.println();
			for(int column = 0; column < numCols; column++) {
				System.out.printf("%c ", puzzleArray[row][column]);
			} //end for column
		} //end for row
	} //end printCrossword
} //end crossword class