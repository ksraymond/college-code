package Final;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class RaymondKeatonFinal {

	
	public static void main(String[] args) {
		Queue<Integer> aQueue = new LinkedList<>();
		Stack<Integer> aStack = new Stack<>();

		// Example queue and stack to test your code on
		aQueue.offer(2);
		aQueue.offer(-40);
		aQueue.offer(-7);
		aQueue.offer(6);
		aQueue.offer(5);

		aStack.push(-53);
		aStack.push(1);
		aStack.push(4);
		aStack.push(-2);
		aStack.push(3);
		aStack.push(-63);

		// ******* ADD SOLUTION HERE *******
		// Write all code in main - no need to create methods
		// Create your own linked list using the provided head and Node class
		
		//priority queue and list object
		PriorityQueue<Integer> positives = new PriorityQueue<>();
		IntegerList list = new IntegerList();
		
		//empty positive queue numbers into priority queue
		while(!aQueue.isEmpty()) {
			Integer temp = aQueue.remove();
			if(temp > 0)
				positives.add(temp);
		} //end while
		
		//empty positive stack numbers into priority queue
		while(!aStack.isEmpty()) {
			Integer temp = aStack.pop();
			if(temp > 0)
				positives.add(temp);
		} //end while
		
		//empty priority queue values into the linked list
		while(!positives.isEmpty()) {
			Integer temp = positives.remove();
			list.add(temp);
		} //end while
		
		//call to print function
		list.print();
		
	} // main

} //end main class

//linked list class
class IntegerList {
	
	private Node head;
	private Node tail;
	
	public IntegerList() {
		head = null;
		tail = null;
	}
	
	//method to add to beginning of list
	public void add(Integer num) {
		Node newNode = new Node(num);

		newNode.next = head;
		head = newNode;
		
		if(tail == null)
			tail = head;
		
	} //end add method
	
	//given method to print list
	public void print() {
		System.out.println("Reverse Sorted Linked List");
		Node current = head;
		while (current != null) {
			int data = current.data;
			current = current.next;
			System.out.print(data + "-->");
		}
		System.out.println("Null");
	} //end print method
	
	// Inner Node Classes
		private static class Node {
			private int data;
			private Node next;

			public Node(int data) {
				this.data = data;
				next = null;
			}
		} //Node
}