

// When writing to and reading from files you need to import several classes.
// You need: File, IOException, PrintWriter and Scanner
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileExample {

	public static void main(String[] args) throws IOException {

		// First note that when working with files main needs to throw an exception.
		// Now let's start with writing to a file.
		// This is a good exercise since it shows you where Eclipse looks for files.
		
		// First setup a file reference variable to refer to the text file. 
		// Note that the file has NOT been created on your hard drive yet,
		// this only creates the reference variable. 
		// The variable fileName is how to refer to the file OutputFile.txt on the hard drive.
		File fileName = new File("OutputFile.txt");	
		
		// Second create the file.	
		// The PrintWriter class is used to write data to a file.
		// I will now use the variable resultsFile any time I need to write to OutputFile.txt
		// If you look on your hard drive you will now see the file OutputFile.txt 
		// The file will be in your eclipse workspace in the CS1450 folder (or whatever you 
		// named your project for this class in Eclipse).
		PrintWriter resultsFile = new PrintWriter (fileName);
		
		// Third write something to the file.
		resultsFile.println("This text will now be written to the file");
		resultsFile.println("This text is also written to the file");
		
		// Fourth close the file.
		// To prove writing to the file worked properly, open the file and verify it contains
		// the above two lines.
		resultsFile.close();
		
		
		// The next step is to read from a file.
		// Reading from a file is very similar to reading from the keyboard.		
		// First open the file for reading by creating a scanner for the file.
		// Note: I'm using the same variable - fileName - so I'm opening the file OutputFile.txt
		// on my hard drive this time for reading.  
		Scanner inputFile = new Scanner (fileName);
		
		// Second prove that I actually read something from the file.
		// Note the use of the method nextLine.  The point is to use the methods in the Scanner class
		// to obtain the information from the file.  With numbers, use nextInt, nextDouble, etc.
		// There is no need to read a line of numbers and then parse the line to get the values.  
		// Let the Scanner methods do the work.
		System.out.println("Value read from OutputFile.txt is: " + inputFile.nextLine());
		
		// Third close the file.
		inputFile.close();
		
	} // main

} //FileExample
