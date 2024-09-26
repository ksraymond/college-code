package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentJ; this class has several
 * 			subclasses, and those in turn have subclasses
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentJ. This is a general class, which will be specialized
 * or extended below. 
 */
class StudentJ{  
	String lastName;
	String firstName;
	private int SSN;  
	int age, academicLevel; 

	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%d\n", this.lastName, this.firstName, 
				this.SSN, this.age, this.academicLevel);

	}

	//A member method to print details of a student
	void printStudent (){
		System.out.println (this.toString());
	}

	public void setSSN (int n){
		this.SSN = n;
	}

	public int getSSN (){
		return this.SSN; 
	}
}

/*This class is for illustration only. We do not expand on this class. 
 * This is a specialized class that inherits the properties of the Student class. 
 * It can extend it by defining new properties and methods. 
 * This is called inheritance. Inheritance allows us to define relationships among classes
 * to reflect the world we are modeling, and also to do so compactly, with code reuse, 
 * avoiding repetitions. 
 */
class CCStudentJ extends StudentJ{
	private static String campus = "Colorado College";	
}

/*We extend this class below. We extend by defining new member and class variables and methods. 
 */
class UCCSStudentJ extends StudentJ{
	private static String campus = "University of Colorado, Colorado Springs";
	private int UCCSSID; 

	//A member method to print details of a student
	void printUCCSStudent (){
		System.out.printf ("%-12s%-10s\t%d\t%d\t%d\t%d\t%s\n", this.lastName, this.firstName, 
				this.getSSN(), this.age, this.academicLevel, this.getUCCSID(), UCCSStudentJ.getCampus());
	}	

	public void setUCCSID (int n){
		this.UCCSSID = n;
	}

	public int getUCCSID (){
		return (this.UCCSSID);
	}

	public static String getCampus (){
		return (campus);
	}


}

/*This class is for illustration only. We do not expand on this class. 
 */
class CTechStudentJ extends StudentJ{
	private static String campus = "Colorado Technical University";

}

/*This class is for illustration only. We do not expand on this class. 
 */
class BUSStudentJ extends UCCSStudentJ{
	private static String college = "Business";

}

/*We extend this class below. 
 */
class EASStudentJ extends UCCSStudentJ{
	private static String college = "Engineering and Applied Science";

	public static String getCollege(){
		return (college);
	}

	//A member method to print details of a student
	void printEAStudent (){
		System.out.printf ("%-12s%-10s\t%d\t%d\t%d\t%s\n", this.lastName, this.firstName, 
				this.getSSN(), this.age, this.academicLevel, college); 
	}	

}

/*This class is for illustration only. We do not expand on this class. 
 */
class LASStudentJ extends UCCSStudentJ{
	private static String college = "Letters, Arts and Sciences";
}

/*We extend this class below.
 */
class CSStudent extends EASStudentJ{
	private static String major = "Computer Science";
	private static int credits2Graduate = 130;
	private static int scienceCredits2Graduate = 20;
	private static int humanitiesCredits2Graduate = 15;
	private static int CSCredits2Graduate = 60;
	private static int technicalElectiveCredits2Graduate = 35; 


	int creditsTaken, scienceCreditsTaken, humanititesCreditsTaken, CSCreditsTaken, 
	technicalElectiveCreditsTaken; 

	void printCSStudent (){
		System.out.printf ("%-12s%-10s\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%s\n", this.lastName, this.firstName, 
				this.getSSN(), this.age, this.academicLevel, this.creditsTaken, this.scienceCreditsTaken, 
				this.humanititesCreditsTaken, this.technicalElectiveCreditsTaken, CSStudent.major); 
	}	

}

/*This class is for illustration only. We do not expand on this class. 
 */
class ECEStudent extends EASStudentJ{
	private static String major = "Electrical and Computer Enginnering";
}

/*This class is for illustration only. We do not expand on this class. 
 */
class MAEStudent extends EASStudentJ{
	private static String major = "Mechanical and Aerospace Engineering";

}

/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O11StudentApp11 {

	public static void main (String[] args){

		//Create a CS student  
		StudentJ student1 = new StudentJ (); 	

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Trudeau";
		student1.firstName = "Justin";
		student1.age = 18;
		student1.academicLevel = 1; 
		student1.setSSN (1111111);

		student1.printStudent ();	

		/*Create another student by calling its second constructor. 
		 * Increment the static member variable. Assign values to member variables for this instance
		 * of students. student2 is an second instance or an object. 
		 */

		UCCSStudentJ uccsStudent1 = new UCCSStudentJ ();
		uccsStudent1.lastName = "Winfrey";
		uccsStudent1.firstName = "Oprah";
		//uccsStudent1.SSN = 111112;  Invisible field so cannot assign
		uccsStudent1.academicLevel = 2;

		uccsStudent1.printUCCSStudent();

		EASStudentJ easStudent1 = new EASStudentJ ();
		easStudent1.printEAStudent();

		CSStudent csStudent1 = new CSStudent (); 
		csStudent1.printCSStudent();

	}
}
