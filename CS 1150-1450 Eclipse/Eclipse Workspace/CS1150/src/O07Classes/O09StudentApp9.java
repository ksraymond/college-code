package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentI; this class has several
 * 			subclasses, and those in turn have subclasses
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentI. 
 */
class StudentI{  
	String lastName;
	String firstName;
	int age, academicLevel; 	

	//No-arg constructor is not available unless explicitly defined, if there are 
	//other constructors. 
	public StudentI (){
	}

	//Define another constructor when we know the student's ID and name
	public StudentI (String last, String first){
		this.lastName = last;
		this.firstName = first; 
	}

	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d", this.lastName, this.firstName, 
				this.age, this.academicLevel);
	}

}

/*This class is for illustration only. We do not expand on this class. 
 * This is a specialized class that inherits the properties of the StudentI class. 
 * It can extend it by defining new properties and methods. 
 * This is called inheritance. Inheritance allows us to define relationships among classes
 * to reflect the world we are modeling, and also to do so compactly, with code reuse, 
 * avoiding repetitions. 
 */
class CCStudentI extends StudentI{
	private static String campus = "Colorado College";	
}

/*We extend this class below. We extend by defining new member and class variables and methods. 
 */
class UCCSStudentI extends StudentI{
	private static String campus = "University of Colorado, Colorado Springs";
	private int UCCSSID; 

	private static int lastUCCSID = 1000000;

	public UCCSStudentI (){
		this.UCCSSID = lastUCCSID; 
		lastUCCSID++; 
	}


	//Define another constructor when we know the student's ID and name
	public UCCSStudentI (String last, String first){
		this.lastName = last;
		this.firstName = first; 
		this.UCCSSID = lastUCCSID; 
		lastUCCSID++; 
	}


	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%d\t%s", this.lastName, this.firstName, 
				this.age, this.academicLevel, this.UCCSSID, campus);
	}	


	public int getUCCSSID (){
		return (this.UCCSSID);
	}

	public static String getCampus (){
		return (campus);
	}


}

/*This class is for illustration only. We do not expand on this class. 
 */
class CTechStudent extends StudentI{
	private static String campus = "Colorado Technical University";

}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O09StudentApp9 {

	public static void main (String[] args){

		//Create a CS student  
		StudentI student1 = new StudentI (); 	

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Trudeau";
		student1.firstName = "Justin";
		student1.age = 18;
		student1.academicLevel = 1; 

		System.out.println (student1.toString ());	

		//UCCSStudent instances inherit instance fields from the parent class
		UCCSStudentI uccsStudent1 = new UCCSStudentI ();
		uccsStudent1.lastName = "Timberlake";
		uccsStudent1.firstName = "Justin";
		uccsStudent1.age = 28; 
		uccsStudent1.academicLevel = 2;

		System.out.println (uccsStudent1.toString ());

		UCCSStudentI uccsStudent2 = new UCCSStudentI ();
		uccsStudent2.lastName = "Winfrey";
		uccsStudent2.firstName = "Oprah";
		uccsStudent2.age = 23;
		uccsStudent2.academicLevel = 3;

		System.out.println (uccsStudent2.toString ());


	}
}
