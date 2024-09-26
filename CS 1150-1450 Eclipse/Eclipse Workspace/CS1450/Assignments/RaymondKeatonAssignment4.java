package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 4
 *Due: 2/20/2020
 *Description: This program will simulate a game of pinball based on info from a file
 *			   it will print out the field, simulate a game, and print the results, all using objects
 */

public class RaymondKeatonAssignment4 {
	public static void main(String[] args) throws IOException{

		//opening files
		File targetFile = new File("PinballMachineTargets.txt");
		Scanner readTargets = new Scanner(targetFile);


		//assigning row and column to 2D array based on file
		int row = readTargets.nextInt();
		int column = readTargets.nextInt();
		PinballMachine pinballMachine = new PinballMachine(row, column);

		int rowNumber, columnNumber, id, points;
		String type;

		//while loop reading the info of each target from the file
		while(readTargets.hasNext()) {
			rowNumber = readTargets.nextInt();
			columnNumber = readTargets.nextInt();
			type = readTargets.next();
			id = readTargets.nextInt();
			points = readTargets.nextInt();

			Target target = new Target(type, id, points);
			pinballMachine.addTargetToPlayingField(rowNumber, columnNumber, target);

		} //end while
		readTargets.close();

		//displaying the playing field
		pinballMachine.displayPlayingField();

		//formatting the heading for the play method, calling the play method to print the game results
		System.out.println("\n\n----------------------------------------------");
		System.out.println("\tSimulate Pinball Game");
		System.out.println("----------------------------------------------");
		System.out.println("Target Hit\tID\tPoints\tScore");
		System.out.println("----------------------------------------------");
		play(pinballMachine);

	} //end main

	public static void play(PinballMachine pinballMachine) throws IOException {

		//opening and reading the play file
		File playFile = new File("Play.txt");
		Scanner readPlay = new Scanner(playFile);
		int score = 0;

		//while loop for reading each set of coordinates in play file
		while(readPlay.hasNext()) {

			int row = readPlay.nextInt();
			int column = readPlay.nextInt();
			Target target = pinballMachine.getTarget(row, column); //getting the target at specific coordinates

			//if there is a target, print out the info and increment the score
			if(target != null) {
				score += target.getPoints();
				System.out.printf("%s\t%d\t%d\t%d\t\n", target.getType(), target.getID(), target.getPoints(), score);
			}

		} //end while

		readPlay.close();
	} //end play method

	public static void printReport(PinballMachine pinballMachine) {
		ArrayList<TargetReport> reports = new ArrayList<>();

		for (int row = 0; row < pinballMachine.getNumberRows(); row++) {

			// For each column in the current row
			for (int column = 0; column < pinballMachine.getNumberColumns(); column++) {

				// Get the next target
				Target target = pinballMachine.getTarget(row, column);

				// If there is a target in this location, create a report and place it in array list
				if (target != null) {

					// Get target details for the report
					String type = target.getType();
					int id = target.getID();
					int points = target.getPoints();
					int hits = target.getHits();

					// Create a report and add to array list
					TargetReport report = new TargetReport(row, column, type, id, points, hits);
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

	}

} //end main class

class PinballMachine {
	private int numberRows, numberColumns;
	private Target[][] targetArray;

	//PinballMachine constructor
	public PinballMachine (int numberRows, int numberColumns) {
		this.numberRows = numberRows;
		this.numberColumns = numberColumns;
		targetArray = new Target[numberRows][numberColumns];
	}

	//getters for the rows and columns
	public int getNumberRows() {
		return numberRows;
	}
	public int getNumberColumns() {
		return numberColumns;
	}

	//method to add the target to the playing field
	public void addTargetToPlayingField(int row, int column, Target target) {
		targetArray[row][column] = target;
	}

	//method to get a target from a certain set of coordinates
	public Target getTarget(int row, int column) {
		return targetArray[row][column];
	}

	//method to print the playing field
	public void displayPlayingField() {		

		for(int i=0; i<numberColumns; i++)
			System.out.printf("\tColumn %d", i);

		//iterating through the array and printing each of the object's names if there is one
		for(int r=0; r<numberRows; r++) {
			System.out.printf("\nRow %d\t", r);

			for(int c=0; c<numberColumns; c++) {
				Target target = getTarget(r, c);

				//if there is no target, print "-------"
				if(target == null)
					System.out.print("-------\t\t");
				else
					System.out.printf(target.getType() + "\t\t");
			} //end c for
		} //end r for
	} //end display playing field

} //end class PinballMachine

//target parent class
class Target {
	private String type;
	private int id, points, hits;

	//target constructor
	public Target(String type, int id, int points){
		this.type = type;
		this.id = id;
		this.points = points;
	}

	//getters for type, id, points, and hits
	public String getType() {
		return type;
	}
	public int getID() {
		return id;
	}
	public int getPoints() {
		return points;
	}
	public int getHits() {
		return hits;
	}

	//method to add the hits
	public int incrementHits() {
		return 0;
	}

} //end class target

//not 100% sure what this is or what it does
class TargetReport  implements Comparable<TargetReport> {
	private int rowNumber, columnNumber, id, points, hits;
	private String type;

	public TargetReport(int rowNumber, int columnNumber, String type, int id, int points, int hits) {
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.type = type;
		this.id = id;
		this.points = points;
		this.hits = hits;
	}

	public String print() {
		return String.format("%d\t%d\t%-10s\t%-1d\t%-4d\t%-4d", rowNumber, columnNumber, type, id, points, hits);
	} //end print

	@Override
	public int compareTo(TargetReport otherReport) {
		if (this.hits < otherReport.hits) 
			return 1;
		else if (this.hits > otherReport.hits) 
			return -1;
		else 
			return 0;
	} //end compareTo
} //end class target report