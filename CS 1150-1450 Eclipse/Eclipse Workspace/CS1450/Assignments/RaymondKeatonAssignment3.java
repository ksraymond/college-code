package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RaymondKeatonAssignment3 {

	public static void main(String args[]) throws IOException{

		File insectFile = new File("insects.txt");
		Scanner readInsect = new Scanner(insectFile);
		int insectSize = readInsect.nextInt();
		Insects[] myInsects = new Insects[insectSize];

		char type;
		String name;
		int pollinate, build, predator, decompose;

		for(int i=0; i<insectSize; i++) {
			type = readInsect.next().charAt(0);
			name = readInsect.next();
			pollinate = readInsect.nextInt();
			build = readInsect.nextInt();
			predator = readInsect.nextInt();
			decompose = readInsect.nextInt();

			switch(type) {
			case 'h': myInsects[i] = new Honeybee(name, pollinate, build); break;
			case 'a': myInsects[i] = new Ant(name, build, predator, decompose); break;
			case 'p': myInsects[i] = new PrayingMantis(name, predator); break;
			case 'l': myInsects[i] = new Ladybug(name, pollinate, predator); break;
			} //switch

		} //for loop

		readInsect.close();
		
		System.out.println();
		System.out.println("INSECTS THAT DON'T HELP WITH DECOMPOSITION!");
		System.out.println("-------------------------------------------");

		ArrayList<Insects> doNotDecompose = findDoNotDecompose(myInsects);
		for(int i=0; i < doNotDecompose.size(); i++) {
			System.out.printf("%s is a %s and does not help with decomposition\n", 
					doNotDecompose.get(i).getName(), doNotDecompose.get(i).getType());
			System.out.println(doNotDecompose.get(i).purpose());
			displayAbilities(doNotDecompose.get(i));
			System.out.println();
		}

		System.out.println();
		System.out.println("INSECT WITH MOST ABILITIES!");
		System.out.println("---------------------------");
		
		int mostAble = findMostAble(myInsects);
		
		System.out.printf("The winner is %s the %s\n%s\n", 
				myInsects[mostAble].getName(), myInsects[mostAble].getType(), myInsects[mostAble].purpose());
		displayAbilities(myInsects[mostAble]);
		System.out.println();

	} //end main method


	//find do not decompose method
	public static ArrayList<Insects> findDoNotDecompose(Insects[] insects) {
		ArrayList<Insects> doNotDecompose = new ArrayList<>();
		for(int i=0; i < insects.length; i++) {
			if (!(insects[i] instanceof Decompose)) 
				doNotDecompose.add(insects[i]);
		}		
		return doNotDecompose;
	} //end findDoNotDecompose

	//find most able method
	public static int findMostAble(Insects[] insects) {
		int mostAbleScore = 0;
		int mostAbleIndex = 0;
		
		for(int i=0; i < insects.length; i++) {
			int abilityScore = 0;
			
			if(insects[i] instanceof Pollinate)
				abilityScore += ((Pollinate)(insects[i])).pollinate();
			if(insects[i] instanceof Build)
				abilityScore += ((Build)(insects[i])).build();
			if(insects[i] instanceof Predator)
				abilityScore += ((Predator)(insects[i])).predator();
			if(insects[i] instanceof Decompose)
				abilityScore += ((Decompose)(insects[i])).decompose();
			if(abilityScore > mostAbleScore) {
				mostAbleScore = abilityScore;
				mostAbleIndex = i;
			}
		} //for loop

		return mostAbleIndex;
	} //end findMostAble

	//display abilities method
	public static void displayAbilities(Insects insect) {
		if(insect instanceof Pollinate)
			System.out.println("Pollinating ability: " + ((Pollinate) insect).pollinate());
		if(insect instanceof Build)
			System.out.println("Build ability: " + ((Build) insect).build());
		if(insect instanceof Predator)
			System.out.println("Predator ability: " + ((Predator) insect).predator());
		if(insect instanceof Decompose)
			System.out.println("Decompose ability: " + ((Decompose) insect).decompose());
	} //end displayAbilities

} //end main class

interface Pollinate{
	public abstract int pollinate();
}

interface Build{
	public abstract int build();
}

interface Predator{
	public abstract int predator();
}

interface Decompose{
	public abstract int decompose();
}

abstract class Insects {
	private String type;
	private String name;

	//getter and setter for type
	public String getType() {
		return type;
	}
	public void setType(String newType) {
		this.type = newType;
	}

	//getter and setter for name
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		this.name = newName;
	}

	public abstract String purpose();
} //end Insects

class Honeybee extends Insects implements Pollinate, Build{
	private int pollinateAbility;
	private int buildAbility;

	public Honeybee(String name, int pollinate, int build) {
		setType("Honeybee");
		setName(name);
		this.pollinateAbility = pollinate;
		this.buildAbility = build;
	}

	@Override
	public int pollinate() {
		return pollinateAbility;
	}
	@Override
	public int build() {
		return buildAbility;
	}

	@Override
	public String purpose() {
		return "I'm popular for producing honey but I also pollinate 35% of the crops! "
				+ "Without me, 1/3 of the food you eat would not be available!";
	}

} //end Honeybee

class Ladybug extends Insects implements Pollinate, Predator{
	private int pollinateAbility, predatorAbility;

	public Ladybug(String name, int pollinate, int predator) {
		setType("Ladybug");
		setName(name);
		this.pollinateAbility = pollinate;
		this.predatorAbility = predator;
	}

	@Override
	public int pollinate() {
		return pollinateAbility;
	}

	@Override
	public int predator() {
		return predatorAbility;
	}

	@Override
	public String purpose() {
		return "Named after the Virgin Mary, I'm considered good luck if I land on you! "
				+ "I'm a pest control expert eating up to 5,000 plant pests during my life span.";
	}

} //end Ladybug

class Ant extends Insects implements Build, Predator, Decompose{
	private int buildAbility, predatorAbility, decomposeAbility;

	public Ant(String name, int build, int predator, int decompose) {
		setType("Ant");
		setName(name);
		this.buildAbility = build;
		this.predatorAbility = predator;
		this.decomposeAbility = decompose;
	}

	@Override
	public int build() {
		return buildAbility;
	}
	@Override
	public int predator() {
		return predatorAbility;
	}
	@Override
	public int decompose() {
		return decomposeAbility;
	}

	@Override
	public String purpose() {
		return "Don't squash me, I'm an ecosystem engineer! "
				+ "Me and my 20 million friends accelerate decomposition of dead wood, "
				+ "aerate soil, improve drainage, and eat insects like ticks and termites!";
	}

} //end Ant

class PrayingMantis extends Insects implements Predator{
	private int predatorAbility;

	public PrayingMantis(String name, int predator) {
		setType("Praying Mantis");
		setName(name);
		this.predatorAbility = predator;
	}

	@Override
	public int predator() {
		return predatorAbility;
	}

	@Override
	public String purpose() {
		return "I'm an extreme predator quick enough to catch a fly. "
				+ "Release me in a garden and I'll eat beetles, grasshoppers, "
				+ "crickets and even pesky moths.";
	}

} //end PrayingMantis