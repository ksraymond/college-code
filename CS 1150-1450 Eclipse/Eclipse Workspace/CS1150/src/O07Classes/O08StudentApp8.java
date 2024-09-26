package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentG with private member variable, with 
 * 			corresponding setter and getter/access methods.  
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentG. Use of 'this' 
 * as the current object on which a method is called. 
 */
class StudentG{  
	String lastName;
	String firstName;
	int age, academicLevel; 

	//SSN field is private, this is a instance field that's private
	//This assignment to SSN is for the default value if a new Student is created without 
	//one by using a constructor. 
	private long SSN = 1999999999;  

	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%d", this.lastName, this.firstName, 
				this.SSN, this.age, this.academicLevel); //SSN can be seen within this class
	}

	//SSN is a private variable, it cannot be seen directly 
	//from outside, to set its value.
	//We define a private method so that it can be set from outside 
	//this class definition. We may not need a setter method al the time.  
	private void setSSN (long n){
		this.SSN = n;
	}

	//SSN is a private variable, to read its value, we define a public method
	//In a "real" get method, one can check to see if the method asking for 
	//an SSN actually have permission to do so. 
	public long getSSN (){	
		return (this.SSN); 
	}

	//constructor, when we write constructors, the no-arg constructor 
	//becomes unavailable; we need to write a no-arg constructor explicitly
	//if we want one. 
	public StudentG (){
	}


	//Define another constructor when we know the student's ID and name
	public StudentG (String last, String first, long SSN){
		this.lastName = last;
		this.firstName = first; 
		this.setSSN (SSN); 
	}

}


public class O08StudentApp8 {

	public static void main (String[] args){

		//Create a student  
		StudentG student1 = new StudentG (); 	

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Trudeau";
		student1.firstName = "Justin";
		student1.age = 18;
		student1.academicLevel = 1; 

		//CAN'T SET SSN FROM HERE SINCE setSSN is a private method
		//student1.setSSN (1111111); 

		//System.out.println (student1.getSSN());
		//We print the student details 
		System.out.println (student1.toString());  

		//A student instance's SSN must be provided at creation/construction time.
		//Once it's given at construction time, it cannot be changed later,
		//providing some protection to the field. Of course, it can be 
		//given wrong at creation time, but the way the student class is written, 
		//we will not be able to change later even if it's wrong. 
		StudentG student2 = new StudentG ("Winfrey", "Oprah", 222111333); 
		System.out.println (student2.toString());

	}
}
