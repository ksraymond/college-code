// Solution CS1450 Assignment 2 Spring 2020
// Topic: Object Review
//
// Note: This solution code may not be copied, doing so will result in a grade of zero.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CS1450_Assignment2_Spring2020 {

	public static void main(String[] args) throws IOException {
		
		// Name of file to read trains from
		final String FILE_NAME = "trains.txt";	
		
		// Setup the file reference variable to refer to the text file
		File inputFileName = new File(FILE_NAME);
		
		// Open file for reading by creating a scanner for the file
		// Read first value in the file, it indicates how many trains are in the file
		Scanner inputFile = new Scanner (inputFileName);
		int numTrains = inputFile.nextInt();

		// Create a polymorphic array to hold the train objects
		// Student Note: Train is the parent of all the train subclasses so creating 
		// an array of type "Train" allows us to place any subclass into the array!
		// Also I named the train class TrainS20 so if when you import this code there 
		// won't be duplicate class names
		TrainS20[] trains = new TrainS20[numTrains];

		// For each line in the file, create correct object and place object into array
		for (int i = 0; i < numTrains; i++) {
			
			// Read type, topSpeed, and name associated with this train
			// Student Note: Notice that the Scanner methods are used to read the individual bits 
			// in the file.  Don't read one line and then parse, use the Scanner method to do the 
			// parsing for you!
			String type = inputFile.next();
			double topSpeed = inputFile.nextDouble();
			String name = inputFile.nextLine().trim();

			// Create correct object based on type of train
			// Student Note: This is where you are creating an object based on the information read
			// from the file.  Note that type is not sent since "type" is known inside the subclass.
			switch (type) {			   
			   case "highspeed": trains[i] = new Highspeed (name, topSpeed); break;
			   case "monorail": trains[i] = new Monorail (name, topSpeed); break;
			   case "lightrail": trains[i] = new Lightrail (name, topSpeed); break;
			   case "cog": trains[i] = new CogTrain (name, topSpeed); break;
			} // switch

		} // for

		// Now demonstrate the power of polymorphism!
		// Have each train in the array indicate its type, name, topSpeed, and benefit.
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.printf("%s\t\t%s\t\t\t%s\t%s\n", "Type", "Name", "Top Speed", "Benefit");
		System.out.println("----------------------------------------------------------------------------------------------------");
		for (int i = 0; i < trains.length; i++) {

			System.out.printf ("%-10s\t", trains[i].getType());
			System.out.printf ("%-20s\t", trains[i].getName());
			System.out.printf ("%-10.2f\t", trains[i].getTopSpeed());
			System.out.printf ("%-10s", trains[i].benefit());
			System.out.println();		
			
		} // for loop

		inputFile.close();

	} // main
	
} // Assignment2


class TrainS20 {

	// Instance variables for a Train
	// These are the bits of information that are the same across all subclasses of trains
	// Student note: Because these are the same across all types of trains, they are stored in the 
	// Train class so that they are not repeated in each subclass.
	private String type;
	private String name;
	private double topSpeed;
	
	// Construct a train with a specific type, name, and top speed
	// Student Note: The subclasses can now call this constructor to set the instance variables.  Note
	// that there are no setters, instead the constructor is used to set the instance variables.
	public TrainS20 (String type, String name, double topSpeed) {
		this.type = type;
		this.name = name;
		this.topSpeed = topSpeed;
	}
		
	// Set train's type
	public String getType() {
		return type;
	}

	// Return train's name
	public String getName() {
		return name;
	}
	
	// Set train's topSpeed
	public double getTopSpeed() {
		return topSpeed;
	}

	// Benefit associated with the Train
	// Student Note: The subclasses will override this method and provide the specific
	// details regarding the benefit for the specific train.
	public String benefit() {
		return "Generic train benefit";
	}
	
} // Train


class Highspeed extends TrainS20 {
	
	// Construct a high speed train with a specific name and topSpeed
	// Student Note: When creating a Highspeed train the name and topSpeed are passed in while the  
	// type is determined here - we are inside the Highspeed train so we know the type is Highspeed!
	// Because the name and topSpeed are in the parent class and because there are no setters, the 
	// only way to set these values when creating a Highspeed train is to call the parent constructor 
	// that takes the values as parameters.  The only way to call the parent constructor is through 
	// the use of the super keyword.
	public Highspeed(String name, double topSpeed) {
		super ("Highspeed", name, topSpeed);
	}
	
	@Override // The benefit of high speed trains
	// Student Note: The benefit is the SAME for all high speed trains so we override
	// the benefit method and specify the benefit in this subclass.
	public String benefit() {								
		return "Travels at speeds between 125 and 267 mph";
	}

} // HighSpeed 


class Monorail extends TrainS20 {
	
	// Construct a monorail train with a specific name and top speed
	public Monorail(String name, double topSpeed) {
		super ("Monorail", name, topSpeed);
	}
	
	
	@Override // The benefit of monorail trains
	public String benefit() {								
		return "Minimal footprint and quieter";
	}

} // Monorail


class Lightrail extends TrainS20 {
	
	// Construct a light rail train with a specific name and top speed
	public Lightrail(String name, double topSpeed) {
		super ("Lightrail", name, topSpeed);
	}
	
	
	@Override // The benefit of light rail trains
	public String benefit() {								
		return "Tighter turning radius"; //, operate on crowed streets";
	}

} // Lightrail



class CogTrain extends TrainS20 {
	
	// Construct a freight train with a specific name and top speed
	public CogTrain(String name, double topSpeed) {
		super ("Cog", name, topSpeed);
	}
	
	
	@Override //  The benefit of cog trains
	public String benefit() {								
		return "Can climb grades up to 48%";
	}

} // CogTrain