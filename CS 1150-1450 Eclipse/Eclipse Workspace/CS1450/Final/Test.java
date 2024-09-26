package Final;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;



public class Test {
	
	public static void main(String args[]) {

		PriorityQueue<Device> devices = new PriorityQueue<>();
		devices.offer(new Device("iPhone", 399));
		devices.offer(new Device("Chromebook", 299));
		devices.offer(new Device("iPad", 499));
		
	}

}

class Device implements Comparable<Device>{
	private String type;
	private int cost;
	
	public Device(String type, int cost) {
		this.type = type;
		this.cost = cost;
	}
	
	public String getType() {
		return type;
	}
	
	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Device otherDevice) {
		if(cost < otherDevice.getCost())
			return -1;
		else if(cost == otherDevice.getCost())
			return 0;
		else
			return 1;
	}
}