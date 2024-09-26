// CS 1450 Spring 2020 Assignment #4 Solution 
// Topic: Nested Objects, 2-dimensional Arrays, Collections and Interfaces
//
// Note: this solution code may not be copied, doing so will result in a grade of zero.
//


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CS1450_Assignment4_Spring2020 {

	public static void main(String[] args) throws IOException {
		
		// Name of file to read from
		final String TARGETS_FILE_NAME = "PinballMachineTargets.txt";	

		// Setup a file reference variable to refer to text file
		File targetsFileName = new File(TARGETS_FILE_NAME);

		// Open the file for reading by creating a scanner for the file.
		// 1st and 2nd values in file tells how many rows and columns are in pinball machine playing field. 
		// Student Note: Use the rows and columns to create a 2-D array that models the playing field.
		Scanner targetsFile = new Scanner (targetsFileName);
		int numberRows = targetsFile.nextInt();
		int numberColumns = targetsFile.nextInt();

		// Create the pinball machine.
		// The pinball machine "HAS-A" playing field with a specified number of rows and columns. 
		// Create a pinball machine based on the values read from the file.
		PinballMachine4 pinballMachine = new PinballMachine4(numberRows, numberColumns);

		// Setup the pinball machine with targets  
		System.out.println("Set up targets in pinball machine...");
		System.out.println();

		// Create the target objects from the details provided in the file.
		// Student Note: In this assignment you are not told how many targets are in the file so you
		// need to use a while loop and the hasNext method on the scanner to read targets until the
		// end of the file is reached.
		while (targetsFile.hasNext()) {
			
			// Read target information from one line in the file into separate variables
			int rowNumber = targetsFile.nextInt();
			int columnNumber = targetsFile.nextInt();
			String type = targetsFile.next();	
			int number = targetsFile.nextInt();
			int points = targetsFile.nextInt();
			
			// Create a target object
			Target4 target = new Target4(type, number, points);			

			// Load target into its correct row/column in the pinball machine's playing field
			pinballMachine.addTargetToPlayingField(rowNumber, columnNumber, target);
		
		} // while more targets

		// Display the pinball machine's playing field
		pinballMachine.displayPlayingField();

		// Simulate a game
		play(pinballMachine);
		
		// Print a report based on hits for all targets in the pinball machine
		printReport(pinballMachine);

		// Close the file
		targetsFile.close();
		
	} // main

	
	// Create and display a report showing the number of times each target was hit during a play session
	public static void printReport (PinballMachine4 pinballMachine) {
	
		// Create an array list to store a report for each target in the pinball machine
		ArrayList<TargetReport4> reports = new ArrayList<>();
		
		// Build a report for each target and place it into the array list
		// For each row in the playing field
		for (int row = 0; row < pinballMachine.getNumberRows(); row++) {
			
			// For each column in the current row
			for (int column = 0; column < pinballMachine.getNumberColumns(); column++) {
				
				// Get the next target
				Target4 target = pinballMachine.getTarget(row, column);
				
				// If there is a target in this location, create a report and place it in array list
				if (target != null) {
					
					// Get target details for the report
					String type = target.getType();
					int id = target.getId();
					int points = target.getPoints();
					int hits = target.getHits();
					
					// Create a report and add to array list
					TargetReport4 report = new TargetReport4(row, column, type, id, points, hits);
					reports.add(report);
				}
			} // for each column
		} // for each row
		
		// Sort the reports stored in the array list - the compareTo method is based on the number of times
		// the target was hit.  We can use the sort method since TargetReport class implements Comparable  
		Collections.sort(reports);
	
		// Display the pinball machine hits on each target from most number of hits to least number of hits
		// Use the print method in the TargetReport class
		System.out.println("\n\n************************************************************************");
		System.out.println("\t\tPINBALL MACHINE TARGET HIT REPORT");
		System.out.println("\t\t(From Most Hits to Least Hits)");
		System.out.println("************************************************************************");
		System.out.printf ("Row\tColumn\tType\t\tId\tPoints\tNumber of Hits\n");
		System.out.println("------------------------------------------------------------------------");

		for (int i = 0; i < reports.size(); i++) {
			System.out.println(reports.get(i).print());
		}
		
	} // printReport
	
	
	public static void play(PinballMachine4 pinballMachine) throws IOException {
		
		// Name of file to read from
		final String PLAY_FILE_NAME = "Play.txt";	

		// Setup a file reference variable to refer to text file
		File playFileName = new File(PLAY_FILE_NAME);

		// Open the file for reading by creating a scanner for the file
		Scanner playFile = new Scanner (playFileName);

		// The file contains the path of the ball.  
		// For each target that gets hit during play, update the targets hit count.
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("             Simulate Pinball Game");
		System.out.println("----------------------------------------------");
		System.out.printf("%s\t%s\t%s\t\t%s\n", "Target Hit", "ID", "Points", "Score");
		System.out.println("----------------------------------------------");
		int score = 0;
		while (playFile.hasNext()) {
			
			// Read information in the file into separate variables
			int rowNumber = playFile.nextInt();
			int columnNumber = playFile.nextInt();
	
			// Obtain the target at the given location
			Target4 target = pinballMachine.getTarget(rowNumber, columnNumber);

			// If the target is not null, then update the hits on that target and the current score
			if (target != null) {
				String type = target.getType();
				int id = target.getId();

				// Update the number of hits for this target
				target.incrementHits();
				
				// Update score with points this target was worth
				int points = target.getPoints();
				score = score + points;
				
				// Display type, points, and current score
				System.out.printf("%-8s\t%d\t%d\t\t%-4d\n", type, id, points, score);
			}
		
		} // while ball is in play

		playFile.close();
		
	} // play

} // Assignment 4


// Represents report for a particular target 
class TargetReport4 implements Comparable<TargetReport4> { 
	
	private int rowNumber;			// Row in the playing field where target is located
	private int columnNumber;		// Column in the playing field where target is located
	private String type;			// Type of target (bumper, kicker, flipper, etc)
	private int id;					// Target's unique id
	private int points;				// Points associated with the target
	private int hits;				// Number of times this target had been hit during play
	
	public TargetReport4 (int rowNumber, int columnNumber, String type, int id, int points, int hits) {
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.type = type;
		this.id = id;
		this.points = points;
		this.hits = hits;
	}

	// Turn target report into a printable string
	public String print() {
		return String.format("%d\t%d\t%-10s\t%-1d\t%-4d\t%-4d", 
							rowNumber, 
							columnNumber, 
							type,
							id,
							points,
							hits);
	}
	
	@Override // This is where we write the code to compare two TargetReports.
	// In this assignment, compare two target reports based on the target's number of hits.
	// By writing this method, it is now possible to sort an array of target reports by number of hits
	// when calling the Collections.sort method
	public int compareTo(TargetReport4 otherReport) {
	
		// Student Note: the variable hits is a private date field on the TargetReport.
		// Since we are inside the TargetReport class it is perfectly fine to access hits 
		// directly, thus, there is no need for a getter.
		if (this.hits < otherReport.hits) {
			return 1;
		}
		else if (this.hits > otherReport.hits) {
			return -1;
		}
		else {
			return 0;
		}

	} // compareTo
	
} // TargetReport


// Represents the Pinball Machine.  
// The pinball machine contains a playing field.
// The playing field is modeled using a 2D array.
// Each location in the playing field contains a target. 
class PinballMachine4 {
	
	private int numberRows;				// Number of rows in the play field 
	private int numberColumns;			// Number of columns in the playing field
	private Target4[][] playingField;	// 2-D array of targets, row 0 and column 0 is not used
										// HAS-A relationship - PinballMachine HAS-A playingField

	public PinballMachine4 (int numberRows, int numberColumns) {
		this.numberRows = numberRows;				// Number of rows in 2D array
		this.numberColumns = numberColumns;			// Number columns in 2D array

		// Create the playing field for the pinball machine
		// The playing field is a 2D array with rows and columns
		// Student Note: The 1st index is the number of rows, the 2nd index is number of columns
		playingField = new Target4[numberRows][numberColumns];
	}

	// Returns the number of rows in the playing field 
	public int getNumberRows() {
		return numberRows;
	}
		
	
	// Returns the number of columns in the playing field
	public int getNumberColumns() {
		return numberColumns;
	}

	
	// Add a target to the playing field in a specific row and column
	public void addTargetToPlayingField (int row, int column, Target4 target) {
		playingField[row][column] = target; 
	}

	
	// Returns the target in the specified row and column in the array.  
	// When a location does NOT contain a target return null.
	public Target4 getTarget(int row, int column) {
		
		// Return the target which could be null if location is empty
		// Student Note: When you created the array, Java initialized the array with null values
		return playingField[row][column];
	}

	
	// Displays the targets in the pinball machine's playing field
	public void displayPlayingField () {

		// Display header for the number of columns in the 2D array
		for (int column = 0; column < numberColumns; column++) {
			System.out.printf("\t%s %d", "Column", column);
		}
		System.out.printf("\n\n");
		
		// For each row in the 2D array display the targets in the row
		for (int row = 0; row < numberRows; row++) {
			
			System.out.printf("%s%d", "Row ", row);
	
			// For each column display the target type otherwise display "----" for null
			for (int column = 0; column < numberColumns; column ++) {
	
				// Get target located in location [row,column]
				Target4 target = playingField[row][column];
				
				// If there is a target in location [row,column] display its type
				if (target != null) {
					System.out.printf ("\t%-8s", target.getType());				
				}
				else {
					System.out.printf ("\t%-8s", "-------");				
				}
			} // for each column
			
			System.out.println();
			System.out.println();
			
		} // for each row
		
	} // displayPlayingField
	
} // PinballMachine


// Represents a target - bumpers, flippers, rollovers, and kickers will be considered targets
class Target4 {

	private String type;		// Type or target (bumper, flipper, etc.)
	private int id;				// The target's unique id
	private int points;			// Points player gets when target is hit
	private int hits;			// Number of times this target had been hit during play

	// Create a target
	public Target4 (String type, int id, int points) {
		this.type = type;
		this.id = id;
		this.points = points;
		this.hits = 0;
	}
		
	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public int getPoints() {
		return points;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void incrementHits() {
		hits++;
	}

} // Target

