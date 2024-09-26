package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentF and another "main" class to 
 * 			create instance/object students. Show use of static member variables
 * 			and member methods. Define a number of constructors for the class.
 * 			In the main class, use a foreach loop to go over each element of an array
 * 			students.  Use of get and set methods for private (static) variables.
 * 			Use of 'this' as the current object on which a method is called.  
 * Date modified: 11/14/2019
 */


/*We define a class/template called StudentF.*/
class StudentF{  //We can have only one class with a specific name within a package
	String lastName;
	String firstName;
	int studentID, age, academicLevel; 	

	//A static field 
	private static int noOfStudents = 0; 	

	//If we define any constructor at all, the default one is no longer available.
	//If we want to use the default one, we have to redefine it like below. We can
	//put anything in it, but must redefine it if we want to use a no-arg constructor. 
	public StudentF (){
		StudentF.setNoOfStudents (); 
	}

	//Define another constructor to override the default constructor called StudentF
	//Provide last name and first name when creating an instance
	public StudentF (String lName, String fName){
		StudentF.setNoOfStudents (); 
		this.lastName = lName;
		this.firstName = fName;		
	}

	//Define another constructor when we know the student's ID and academicLevel
	public StudentF (int ID, int level){
		setNoOfStudents ();  // could also do without StudentF.
		this.studentID = ID;
		this.academicLevel = level; 
	}


	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%d", this.lastName, this.firstName, 
				this.studentID, this.age, this.academicLevel);
	}

	/* I don't think we should let anyone outside this class
	 * mess the static variable noOfStudents. It's a private method.
	 * The field noOfStudents is private in the sense that others can see it, 
	 * but cannot modify it. 
	 * It's also a static method*/
	//public static void setNoOfStudents() {
	private static void setNoOfStudents() {
		noOfStudents++; 		
	}


	//This one would be very useful because noOfStudents is a private static field
	public static int getNoOfStudents(){
		return noOfStudents; 
	}

}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O07StudentApp7 {

	public static void main (String[] args){

		//Create a student by calling its default constructor "StudentF", 
		StudentF student1 = new StudentF (); 

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Reuter";
		student1.firstName = "Jack";
		student1.studentID = 111111;
		student1.age = 18;
		student1.academicLevel = 1; 


		/*********************
		 * Cannot access private fields or methods outside the class definition StudentF
		 */
		//StudentF.noOfStudents++; 
		//StudentF.setNoOfStudents(); 

		/*Create another student by calling its second constructor. 
		 * Increment the static member variable. Assign values to member variables for this instance
		 * of students. student2 is an second instance or an object. 
		 */
		StudentF student2 = new StudentF ("Richardson", "Valerie"); 

		//Assign values to member variables 
		student2.studentID = 222222;
		student2.age = 19;
		student2.academicLevel = 1;

		/*Create a third student by calling its third constructor. 
		 */
		StudentF student3 = new StudentF (333333, 2); 

		//Assign values to member variables 
		student3.lastName = "Peterson";
		student3.firstName = "Luke";
		student3.age = 19; 

		//Defining an array of students
		StudentF[] students = {student1, student2, student3};

		//print the member variables of the two instances of StudentF class
		System.out.println ("We have created " + StudentF.getNoOfStudents() + " instances of class StudentF.\n");
		System.out.println ("Last        First\tID\tAge\tYear"); 

		//We print the student details by using a foreach loop over the array students
		for (StudentF s:students){
			System.out.println (s.toString ());		
		}


	}
}
