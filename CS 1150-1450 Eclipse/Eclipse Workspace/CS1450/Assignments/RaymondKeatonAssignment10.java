package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 9
 *Due: 4/21/2020
 *Description:  This program will read parrots from a file and insert them into
 *				a binary search tree. Once in that tree they will sing a song,
 *				each parrot has a word of the song associated with it, if placed
 *				into the correct spots in the tree when it is traversed it will
 *				form a song. The program will then call to a recursive method
 *				that prints the names of each parrot that is a leaf node from left to right.
 */

public class RaymondKeatonAssignment10 {

	public static void main(String args[]) throws IOException{
		//opening and reading file, making binary tree, and variables for file
		File parrotFile = new File("parrots.txt");
		Scanner readParrots = new Scanner(parrotFile);
		BinaryTree parrotTree = new BinaryTree();
		int id;
		String name, songWord;

		//adding parrots from file into the tree
		while(readParrots.hasNext()) {
			id = readParrots.nextInt();
			name = readParrots.next();
			songWord = readParrots.next();

			parrotTree.insert(new Parrot(id, name, songWord));
		}
		
		//printing out the parrots song
		System.out.println("Parrot's Song");
		System.out.println("-------------------------------");
		parrotTree.levelOrder();

		//printing out the parrots that are on leaf nodes
		System.out.println("\n\nLeaf Node Parrots");
		System.out.println("-------------------------------");
		parrotTree.visitLeaves();
		
		readParrots.close();
	} //end main method
} //end main class

//class to represent a parrot object
class Parrot implements Comparable<Parrot>{
	private int id;
	private String name, songWord;

	public Parrot(int id, String name, String songWord) {
		this.id = id;
		this.name = name;
		this.songWord = songWord;
	} //end constructor

	public String getName() {
		return name;
	} //end getName

	public String sing() {
		return songWord;
	} //end sing

	//compareTo method to compare 2 parrots ID's
	@Override
	public int compareTo(Parrot otherParrot) {
		if(id < otherParrot.id)
			return -1;
		else if(id == otherParrot.id)
			return 0;
		else
			return 1;
	} //end compareTo
} //end parrot class

//class to represent the binary tree
class BinaryTree {
	private TreeNode root;

	public BinaryTree() {
		root = null;
	} //end constructor

	//method to insert a parrot into the tree
	public boolean insert(Parrot parrotToAdd) {
		if(root == null)
			root = new TreeNode(parrotToAdd);
		else {
			TreeNode parent = null;
			TreeNode current = root;

			while(current != null) {
				if(parrotToAdd.compareTo(current.parrot) == -1) {
					parent = current;
					current = current.left;
				}
				else if(parrotToAdd.compareTo(current.parrot) == 1) {
					parent = current;
					current = current.right;
				}
				else
					return false;
			} //end while

			if(parrotToAdd.compareTo(parent.parrot) == -1)
				parent.left = new TreeNode(parrotToAdd);
			else
				parent.right = new TreeNode(parrotToAdd);
		} //end else

		return true;
	} //end insert

	//method to print the song in the correct order
	public void levelOrder() {
		if(root != null) {
			Queue<TreeNode> orderQueue = new LinkedList<>();
			orderQueue.offer(root);

			while(!orderQueue.isEmpty()) {
				TreeNode tempNode = orderQueue.remove();
				System.out.print(tempNode.parrot.sing() + " ");

				if(tempNode.left != null)
					orderQueue.offer(tempNode.left);
				if(tempNode.right != null)
					orderQueue.offer(tempNode.right);
			} //end while
		} //end if

	} //end level order

	//method accessible from main that calls to the recursive method
	public void visitLeaves() {
		visitLeaves(root);
	} //end public visit leaves

	//recursive method to print the leaf node parrots
	private void visitLeaves(TreeNode node) {
		if(node == null) 
			return;
		else if(node.left == null && node.right == null)
			System.out.println(node.parrot.getName());
		
		visitLeaves(node.left);
		visitLeaves(node.right);
	} //end private visit leaves

	//inner class representing each node on the tree
	private static class TreeNode {
		private Parrot parrot;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(Parrot parrot) {
			this.parrot = parrot;
			left = null;
			right = null;
		} //end constructor
	} //end TreeNode inner class
} //end BinaryTree class