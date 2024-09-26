package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 9
 *Due: 4/21/2020
 *Description:  This program will read elephants from a file and place them in a
 *				linked list. The linked list will be made from scratch, not the
 *				JCF linked list. The program will print the name and weight of 
 *				each elephant, followed by the total weight of the elephants,
 *				and will then remove and print each elephant from the list from
 *				heaviest to lightest.
 */

public class RaymondKeatonAssignment9 {

	public static void main(String[] args) throws IOException{
		
		//opening and reading the file, making the linked list, and making variables for reading the file
		File elephantFile = new File("elephants.txt");
		Scanner readElephants = new Scanner(elephantFile);
		ElephantLinkedList elephantList = new ElephantLinkedList();
		String name;
		int weight;
		
		//putting each elephant into the list
		while(readElephants.hasNext()) {
			name = readElephants.next();
			weight = readElephants.nextInt();
			elephantList.add(new Elephant(name, weight));
		}
		
		//printing each elephant in the list
		System.out.println("Step 1: Created and placed elephants in linked list\n");
		System.out.println("Elephant\tWeight");
		System.out.println("--------------------------------");
		elephantList.printList();
		
		//printing the total weight of the elephants
		System.out.println("\nStep 2: Find total weight for all elephants\n");
		System.out.printf("Total weight of all elephants is: %d lbs\n", elephantList.getTotalWeight());
		
		//removing the elephants from heaviest to lightest
		System.out.println("\nStep 3: Find and remove elephants, heaviest to lightest\n");
		while(!elephantList.isEmpty()) {
			Elephant heaviest = elephantList.findHeaviest();
			System.out.printf("Removing: %s weighing in at %d lbs\n", 
					heaviest.getName(), heaviest.getWeight());
			elephantList.remove(heaviest);
		} //end while

		readElephants.close();
	} //end main class

} //end main method

//class respresenting each elephant
class Elephant {
	private String name;
	private int weight;

	//elephant constructor
	public Elephant(String name, int weight) {
		this.name = name;
		this.weight = weight;
	} //end constructor

	//getters for name and weight
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}

	//method to print each elephants name and weight
	public void print() {
		System.out.printf("%s\t\t%d\n", name, weight);
	} //end print
} //end Elephant class


//class for the linked list of elephants
class ElephantLinkedList {
	private node head;
	private node tail;

	//constructor
	public ElephantLinkedList() {
		head = null;
		tail = null;
	} //end constructor

	//method to see if the list is empty
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	} //end isEmpty method

	//method to return the total weight of the elephants
	public int getTotalWeight() {
		int total = 0;
		node temp = head;
		//while there are still elephants, add their weight to the total weight
		while(temp != null) {
			total += temp.elephant.getWeight();
			temp = temp.next;
		} //end while
		return total;
	} //end getTotalWeight method

	//method to add an elephant to the lsit
	public void add(Elephant elephant) {
		node newNode = new node(elephant);

		//if no values yet, the head and the tail are the new node
		if(tail == null) {
			head = tail = newNode;
		} //end if
		//else if there are values, add the elephant as the new tail
		else {
			tail.next = newNode;
			tail = newNode;
		} //end else
	} //end add method

	//method to find the heaviest elephant in the list
	public Elephant findHeaviest() {
		//if the list is empty, return null
		if(isEmpty())
			return null;
		else {
			node temp = head; //keeps track of where the loop is in the list
			node returnElephant = temp; //keeps track of the heaviest elephant
			int heaviest = 0; //keeps track of the weight of the heaviest elephant
			
			//if there is only 1 elephant, return that elephant
			if(temp.next == null) {
				return temp.elephant;
			}
			
			//while there are still elephants in the list,
			//check if each elephant is the heaviest, if it is make it the new heaviest
			while(temp != null) {
				if(temp.elephant.getWeight() > heaviest) {
					heaviest = temp.elephant.getWeight();
					returnElephant = temp;
				} //end if
				temp = temp.next;
			} //end while
			return returnElephant.elephant;
		} //end else
	} //end find heaviest method

	//method to remove a specific elephant from the list
	public void remove(Elephant elephant) {
		//if there are elephants in the list
		if(head != null) {
			//if the passed in elephant is the head, remove the head
			if(elephant == head.elephant) {
				head = head.next;
			} //end if

			else {
				node previous = head;

				//while loop to get previous to be the elephant before
				//the elephant you wish to remove
				while(previous.next.elephant != elephant) {
					previous = previous.next;
				} //end while

				//removing the elephant
				node temp = previous.next;
				previous.next = temp.next;
			} //end else
		} //end if
	} //end remove

	//method to print the list of elephants after they are put into list
	public void printList() {
		node temp = head;
		while(temp.next != null) {
			temp.elephant.print();
			temp = temp.next;
		} //end while
	} //end printList

	//inner node class
	private static class node {
		private Elephant elephant;
		private node next;

		//node constructor
		public node(Elephant elephant) {
			this.elephant = elephant;
			next = null;
		} //end constructor
	} //end class node

} //end class ElephantLinkedList