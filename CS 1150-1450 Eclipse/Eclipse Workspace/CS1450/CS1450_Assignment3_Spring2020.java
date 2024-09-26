// Solution CS1450 Assignment 3 Spring 2020
// Topic: Abstract Classes and Interfaces and ArrayLists
//
// Note: This solution code may not be copied, doing so will result in a grade of zero.



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CS1450_Assignment3_Spring2020 {

	public static void main(String[] args) throws IOException {

		// Name of file to read insects from
		final String FILE_NAME = "insects.txt";

		// Setup the file reference variable to refer to the text file
		File inputFileName = new File(FILE_NAME);

		// Open file for reading by creating a scanner for the file
		// Read first value in the file, it indicates how many insects are in the file
		Scanner insectFile = new Scanner(inputFileName);
		int numInsects = insectFile.nextInt();

		// Create an array to store the insects - must use an array, not an array list
		// Student Note: Insect is the parent of all the Insect subclasses so creating
		// an array of type "Insect" allows us to place any subclass into the polymorphic array
		Insect3[] insects = new Insect3[numInsects];

		// For each line in the file, create correct insect object and place into array
		for (int i = 0; i < numInsects; i++) {

			// Read the information for this insect into separate variables
			// Student Note: it is better to read the individual pieces into separate variables of
			// the expected data types. This code shows the reading of 2 string values then 4 ints
			// which matches the exact format of the file. No need to read entire line then parse,
			// let the Scanner do the parsing work for you
			String type = insectFile.next();
			String name = insectFile.next();
			int pollinateAbility = insectFile.nextInt();
			int buildAbility = insectFile.nextInt();
			int predatorAbility = insectFile.nextInt();
			int decomposeAbility = insectFile.nextInt();

			// Create the correct insect based on the "type" read from the file
			// An insect's constructor takes only the abilities the insect has 
			// Student Note: the insect's abilities come from the table in the assignment sheet
			switch (type) {
				case "h":
					insects[i] = new Honeybee3(name, pollinateAbility, buildAbility);
					break;
				case "l":
					insects[i] = new Ladybug3(name, pollinateAbility, predatorAbility);
					break;
				case "a":
					insects[i] = new Ant3(name, buildAbility, predatorAbility, decomposeAbility);
					break;
				case "p":
					insects[i] = new PrayingMantis3(name, predatorAbility);
					break;
			} // switch

		} // for

		insectFile.close();

		// Perform 2 tasks:
		// 1) Find all insects that do not help with the decomposition process 
		// 2) Find the insect that has the most abilities

		// Task #1: find all insects that do not help with decomposition
		// First find all insects in the array that are not decomposers and store them in an array list
		System.out.println();
		System.out.println("INSECTS THAT DON'T HELP WITH DECOMPOSITION!");
		System.out.println("-------------------------------------------");

		// The ArrayList returned contains ONLY insect that don't help decompose, now display these insects
		ArrayList<Insect3> doNotDecompose = findDoNotDecompose(insects);
		for (int i = 0; i < doNotDecompose.size(); i++) {

			System.out.println(doNotDecompose.get(i).getName() + " is a " + doNotDecompose.get(i).getType()
					+ " and does not help with decomposition");
			System.out.println(doNotDecompose.get(i).purpose());
			displayAbilities(doNotDecompose.get(i));
			System.out.println();

		} // for non-decomposer insects

		
		// Task #2: find the one insect that has the most abilities from all the insects in the array
		System.out.println();
		System.out.println("INSECT WITH MOST ABILITIES!");
		System.out.println("---------------------------");

		// Find the index in the array for the insect that is the most able.
		int mostAble = findMostAble(insects);

		// Display the most able insect's type, name, purpose, and abilities
		System.out.println("The winner is " + insects[mostAble].getName() + " the " + insects[mostAble].getType());
		System.out.println(insects[mostAble].purpose());
		displayAbilities(insects[mostAble]);
		System.out.println();

	} // main

	
	// Method to determine which insects in the array don't help in the decomposition process
	// Input: Array of insect objects
	// Output: ArrayList of insect objects that are NOT an instance of the Decompose interface
	public static ArrayList<Insect3> findDoNotDecompose(Insect3[] insects) {

		// Create an array list for the insects that are not decomposers
		ArrayList<Insect3> doNotDecompose = new ArrayList<>();

		// Iterate through array and find the insects that are not decomposers and place them into array list
		for (int i = 0; i < insects.length; i++) {

			// Insects that decompose implement the Decompose interface
			// If the current insect is NOT an instance of Decomposer, add to the doNotDecompose ArrayList
			if (!(insects[i] instanceof Decomposer3)) {
				doNotDecompose.add(insects[i]);
			}
		} // for

		return doNotDecompose;

	} // findDoNotDecompose

	
	// Method to determine which insect in the array is most able, that is, which 
	// insect has the highest numeric value for all combined abilities.
	// Input: Array of insect objects
	// Output: Index of insect with highest level of all abilities combined
	public static int findMostAble(Insect3[] insects) {

		// Start with 0 as the most able
		int mostAbleScore = 0;
		int mostAbleIndex = 0;

		// Iterate through the insects array and find the insect that is most able
		for (int i = 0; i < insects.length; i++) {

			int abilityScore = 0;

			// Insects that can pollinate implement the Pollinator interface
			// Check if the current insect in the array is an instance of Pollinator
			if (insects[i] instanceof Pollinator3) {

				// insect[i] can pollinate so cast to Pollinate interface to get it's pollinate ability.
				// Casting is needed because insect[i] is of type Insect not Pollinator but we've proven
				// this insect can pollinate so use the cast and call the pollinate method and add that  
				// value to this insect's overall ability score.
				abilityScore = abilityScore + ((Pollinator3) (insects[i])).pollinate();
			} 
			if (insects[i] instanceof Builder3) {
				abilityScore = abilityScore + ((Builder3) (insects[i])).build();
			}
			if (insects[i] instanceof Predator3) {
				abilityScore = abilityScore + ((Predator3) (insects[i])).predator();
			}
			if (insects[i] instanceof Decomposer3) {
				abilityScore = abilityScore + ((Decomposer3) (insects[i])).decompose();
			}

			// Is this insects's overall ability score greater than the current value in mostAbleScore?
			// If it is, then make this insect the most able so far by saving its location in the array!
			if (abilityScore > mostAbleScore) {
				mostAbleScore = abilityScore;
				mostAbleIndex = i;
			}
		} // for

		return mostAbleIndex;

	} // findMostAble

	
	// Method to display an insect's ability values.
	// Input: Insect object
	// Output: None
	public static void displayAbilities(Insect3 insect) {

		// Student Note: when displaying the insects's different abilities we need to cast. 
		// The reason casting is needed is because the object sent to this method is of type Insect
		// but the pollinate(), build(), predator() and decompose() methods are only available for the 
		// Pollinator, Builder, Predator, and Decompose data types NOT the Insect data type.  To handle
		// this, first determine if the insect is a Pollinator, then if it is cast the insect to a 
		// Pollinator, and finally make the call to the pollinate method.  Notice the placement of the 
		// parentheses when casting!  Do the same for the other interfaces as well.
		
		// Without casting, an error occurs when calling the pollinate method on insect - the error says 
		// the method pollinate() is undefined for type Insect.  This occurs because the "pollinate" method 
		// is defined on Pollinator, not Insect. But if we know our insect is a pollinator we can cast the
		// "Insect" to a Pollinator and call the method.
		
		// Is the insect an instance of Pollinator?  If it is, display pollinate ability.
		if (insect instanceof Pollinator3) {
			System.out.println("Pollinating ability " + ((Pollinator3) insect).pollinate());
		} 

		// Is the insect an instance of Builder?  If it is, display build ability.
		if (insect  instanceof Builder3) {
			System.out.println("Building ability " + ((Builder3) insect).build());
		}

		// Is the insect an instance of Predator?  If it is, display predator ability.
		if (insect instanceof Predator3) {
			System.out.println("Predator ability " + ((Predator3) insect).predator());
		}
		
		// Is the insect an instance of Decomposer?  If it is, display decompose ability.
		if (insect instanceof Decomposer3) {
			System.out.println("Decomposer ability " + ((Decomposer3) insect).decompose());
		}
		
	} // displayAbilities
	
} // Assignment 3


// Student Note: I placed the number 3 at the end of all the interfaces and classes.
// This will remove any naming conflicts when you import this code into your IDE.

// Interface for insects that have ability to pollinate
interface Pollinator3 {

	// Ability level at which insect pollinates
	public int pollinate();

}

// Interface for insects that have ability to build
interface Builder3 {

	// Ability level at which insect builds
	public int build();

}

// Interface for insects that have ability to be predators
interface Predator3 {

	// Ability level at which insect eats other insects/plants
	public int predator();

}

// Interface for insect that have ability to decompose
interface Decomposer3 {

	// Ability level at which insect decomposes dead animals/plants
	public int decompose();

}

// Abstract class representing an insect
// Unlike assignment #2 where I included a constructor, here a constructor is not include in the Insect class. 
// Instead, Java will create the default constructor and we will use the setters to set the name and type of 
// the different insects.  I wanted you to see both approaches - either one works.
abstract class Insect3 {
	// Instance variables for a Insect
	// These are the bits of information that are the same across all subclasses of Insects
	private String name;
	private String type;

	// Return insect's type
	public String getType() {
		return type;
	}

	// Return insects's name
	public String getName() {
		return name;
	}

	// Set insect's type
	public void setType(String type) {
		this.type = type;
	}

	// Set insect's name
	public void setName(String name) {
		this.name = name;
	}

	// Return some details about the insect's purpose
	// Student Note: Because this is abstract it FORCES all subclasses to implement this method!
	public abstract String purpose();

} // Insect


//Class representing a Honey Bee
class Honeybee3 extends Insect3 implements Pollinator3, Builder3 {

	private int pollinateAbility; 	// How well a honey bee pollinates
	private int buildAbility; 		// How well a honey bee builds

	// Looking back at assignment #2, we called super to set the name and topSpeed on a specific train.
	// Here I'm showing how setter methods can be used to set the name and type.
	// The variables pollinateAbility and buildAbility are specific to a Honeybee so they are not in parent.
	// Note: Honeybees are not predators or decomposers so there is no predatorAbility or decomposeAbility 
	// sent in the Honeybee constructor, nor should there be!
	public Honeybee3(String name, int pollinateAbility, int buildAbility) {
		setName(name);
		setType("Honeybee");
		this.pollinateAbility = pollinateAbility;
		this.buildAbility = buildAbility;
	}

	@Override // Implement pollinate method in Pollinator - returns Honey Bee's pollinating ability
	public int pollinate() {
		return pollinateAbility;
	}

	@Override // Implement build method in Builder - returns Honey Bee's building ability
	public int build() {
		return buildAbility;
	}

	@Override // Override purpose method in Insect - returns Honey Bee's purpose
	public String purpose() {
		return "I'm popular for producing honey but I also pollinate 35% of the crops! Without me, 1/3 of the food you eat would not be available!";
	}

} // HoneyBee


// Class representing a Ladybug
class Ladybug3 extends Insect3 implements Pollinator3, Predator3 {

	private int pollinateAbility; 	// How well a lady bug pollinates
	private int predatorAbility; 	// How well a lady bug eats other bugs/plants

	public Ladybug3(String name, int pollinateAbility, int predatorAbility) {
		setName(name);
		setType("Ladybug");
		this.pollinateAbility = pollinateAbility;
		this.predatorAbility = predatorAbility;
	}

	@Override // Implement pollinate method in Pollinator - returns Ladybug's pollinating ability
	public int pollinate() {
		return pollinateAbility;
	}

	@Override // Implement predator method in Builder - returns Ladybug's predator ability
	public int predator() {
		return predatorAbility;
	}

	@Override // Override purpose method in Insect - returns Ladybug's purpose
	public String purpose() {
		return "Named after the Virgin Mary, I'm consider good luck if I land on you! I'm a pest control expert eating up to 5,000 plant pests during my life span.";
	}

} // Ladybug


// Class representing an Ant
class Ant3 extends Insect3 implements Builder3, Predator3, Decomposer3 {

	private int buildAbility; 		// How well an ant builds
	private int predatorAbility; 	// How well an ant eats other bugs/plants
	private int decomposeAbility; 	// How well an ant decomposes dead insects/plants

	public Ant3(String name, int buildAbility, int predatorAbility, int decomposeAbility) {
		setName(name);
		setType("Ant");
		this.buildAbility = buildAbility;
		this.predatorAbility = predatorAbility;
		this.decomposeAbility = decomposeAbility;
	}

	@Override // Implement build method in Builder - returns Ant's building ability
	public int build() {
		return buildAbility;
	}

	@Override // Implement predator method in Builder - returns Ladybug's predator ability
	public int predator() {
		return predatorAbility;
	}

	@Override // Implement decompose method in Decompose - returns Ant's decompose ability
	public int decompose() {
		return decomposeAbility;
	}

	@Override // Override purpose method in Insect - returns Ant's purpose
	public String purpose() {
		return "Don't squash me, I'm an ecosystem engineer! Me and my 20 million friends accelerate decomposition of dead wood, aerate soil, improve drainage, and eat insects like ticks and termites!";
	}

} // Ant


// Class representing a PrayingMantis
class PrayingMantis3 extends Insect3 implements Predator3 {

	private int predatorAbility; // How well a praying mantis eats other bugs/plants

	public PrayingMantis3(String name, int predatorAbility) {
		setName(name);
		setType("Praying Mantis");
		this.predatorAbility = predatorAbility;
	}

	@Override // Implement predator method in Builder - returns Praying Mantis predator ability
	public int predator() {
		return predatorAbility;
	}

	@Override // Override purpose method in Insect - returns Praying Mantis purpose
	public String purpose() {
		return "I'm an extreme predator quick enough to catch a fly. Release me in a garden and I'll eat beetles, grasshoppers, crickets and even pesky moths";
	}

} // PrayingMantis

