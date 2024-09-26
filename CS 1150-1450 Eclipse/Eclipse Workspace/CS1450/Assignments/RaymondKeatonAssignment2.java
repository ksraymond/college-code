package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RaymondKeatonAssignment2 {
	public static void main(String args[]) throws IOException {

		//creating file and polymorphic array
		File trainFile = new File("trains.txt");	
		Scanner readTrains = new Scanner (trainFile);
		Train[] myTrains = new Train[readTrains.nextInt()];

		//creating variables for trains
		double topSpeed;
		String type = "";
		String name;

		//for loop that reads the type, speed, and name of each train
		for(int i=0; i<myTrains.length; i++) {
			type = readTrains.next();
			topSpeed = readTrains.nextDouble();
			name = readTrains.nextLine().trim();

			//switch statement to assign the variables to each object depending on type
			//don't pass in type b/c that is assigned inside the class
			switch (type) {			   
			case "highspeed": myTrains[i] = new Highspeed (name, topSpeed); break;
			case "monorail": myTrains[i] = new Monorail (name, topSpeed); break;
			case "lightrail": myTrains[i] = new Lightrail (name, topSpeed); break;
			case "cog": myTrains[i] = new CogTrain (name, topSpeed); break;
			} // switch
		} //end for loop

		//printing the output
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Type\t\tName\t\t\tTop Speed\tBenefit");
		System.out.println("----------------------------------------------------------------------------------------------");
		for(int i=0; i<myTrains.length; i++) {
			System.out.printf("%-10s\t%-20s\t%-10.2f\t%-10s\n", 
					myTrains[i].getType(), myTrains[i].getName(), myTrains[i].getTopSpeed(), myTrains[i].benefit());
		}

		readTrains.close();
	} //end main method
} //end main class

//superclass
class Train {
	//variables that are passed into the class from main
	private String type;
	private String name;
	private double topSpeed;

	//creating "master" train object and bringing in each of the variables passed in
	public Train(String type, String name, double topSpeed) {
		this.type = type;
		this.name = name;
		this.topSpeed = topSpeed;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public String benefit() {
		return "train benefit";
	}

} //end train class

//subclass for highspeed train, extends says that it is a subclass of train
class Highspeed extends Train {
	//taking name and topSpeed from the main method
	public Highspeed(String name, double topSpeed) {
		//passing the type, name, and topSpeed to the superclass
		super("HighSpeed", name, topSpeed);
	}
	//overrides the benefit method becuase that one is different for each train
	@Override
	public String benefit() {
		return "Travels at speeds between 125 and 267 mph";
	}
}

class Monorail extends Train {
	public Monorail(String name, double topSpeed) {
		super("Monorail", name, topSpeed);
	}
	@Override
	public String benefit() {
		return "Minimal footprint and quieter";
	}
}

class Lightrail extends Train {
	public Lightrail(String name, double topSpeed) {
		super("Lightrail", name, topSpeed);
	}
	@Override
	public String benefit() {
		return "Tighter turning radius";
	}
}

class CogTrain extends Train {
	public CogTrain(String name, double topSpeed) {
		super("Cog", name, topSpeed);
	}	
	@Override
	public String benefit() {
		return "Can climb grades up to 48%";
	}
}