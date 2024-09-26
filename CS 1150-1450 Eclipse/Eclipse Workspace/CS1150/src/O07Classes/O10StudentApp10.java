package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentK; this class has several
 * 			subclasses, and those in turn have subclasses
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentK. This is a general class, which will be specialized
 * or extended below. 
 */
class StudentK {  
	String lastName;
	String firstName;
	int age, academicLevel; 


	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d", this.lastName, this.firstName, 
				this.age, this.academicLevel);
	}

}

/*This class is for illustration only. We do not expand on this class. 
 * This is a specialized class that inherits the properties of the Student class. 
 * It can extend it by defining new properties and methods. 
 * This is called inheritance. Inheritance allows us to define relationships among classes
 * to reflect the world we are modeling, and also to do so compactly, with code reuse, 
 * avoiding repetitions. 
 */
class CCStudentK extends StudentK{
	private static String campus = "Colorado College";	
}

/*We extend this class below. We extend by defining new member and class variables and methods. 
 */
class UCCSStudentK extends StudentK{
	private static String campus = "University of Colorado, Colorado Springs";
	private long UCCSSID; 

	private static long LastUCCSID = 10000000; 

	public UCCSStudentK (){
		this.UCCSSID = LastUCCSID; 
		LastUCCSID++; 
	}

	public long getUCCSSID (){
		return (this.UCCSSID);
	}

	public static String getCampus (){
		return (campus);
	}

	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%s\t%s", this.lastName, this.firstName, 
				this.age, this.academicLevel, this.getUCCSSID(), getCampus());
	}		

}

/*This class is for illustration only. We do not expand on this class. 
 */
class CTechStudentK extends StudentK{
	private static String campus = "Colorado Technical University";

}

/*This class is for illustration only. We do not expand on this class. 
 */
class BUSStudentK extends UCCSStudentK{
	private static String college = "Business";

}

/*We extend this class below. 
 */
class EASStudentK extends UCCSStudentK{
	private static String college = "Engineering and Applied Science";

	public static String getCollege(){
		return (college);
	}

	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%d\t%s\t%s", this.lastName, this.firstName, 
				this.age, this.academicLevel, this.getUCCSSID(), getCampus(),
				getCollege());
	}	

}

/*This class is for illustration only. We do not extend this class. 
 */
class LASStudentK extends UCCSStudentK{
	private static String college = "Letters, Arts and Sciences";
}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O10StudentApp10 {

	public static void main (String[] args){

		//Create a student  
		StudentK student1 = new StudentK (); 				
		//Assign values to member variables for this instance of students. 
		student1.lastName = "Trudeau";
		student1.firstName = "Justin";
		student1.age = 18;
		student1.academicLevel = 1; 			
		System.out.println (student1.toString ());	


		UCCSStudentK uccsStudent1 = new UCCSStudentK ();
		uccsStudent1.lastName = "Winfrey";
		uccsStudent1.firstName = "Oprah";
		uccsStudent1.academicLevel = 2;	
		uccsStudent1.age = 23; 
		System.out.println (uccsStudent1.toString());

		EASStudentK easStudent1 = new EASStudentK (); 
		easStudent1.firstName = "Justin";
		easStudent1.lastName = "Timberlake";
		easStudent1.academicLevel = 3;
		easStudent1.age = 28; 
		System.out.println (easStudent1.toString()); 
	}
}