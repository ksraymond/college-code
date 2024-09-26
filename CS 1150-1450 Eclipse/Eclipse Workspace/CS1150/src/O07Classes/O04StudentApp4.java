package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentC and another "main" class to 
 * 			create instance/object students. Show use of static member variables
 * 			and member methods. 
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentC.*/
class StudentC{  //We can have only one class with a specific name within a package
	String lastName;
	String firstName;
	int studentID, age, academicLevel; 	

	//A static field 
	static int noOfStudents = 0; 

	//A member method to print details of a student
	//Every class is supposed to provide a toString method so that
	//the content of an object instance can be printed in a readable manner. 
	public String toString (){
		return String.format ("%s\t%s\t%d\t%d\t%d", lastName, firstName, 
				studentID, age, academicLevel);
	}
}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O04StudentApp4 {

	public static void main (String[] args){

		//Create a student by calling its default constructor "StudentC", 
		StudentC student1 = new StudentC ();

		//Increment the static member variable for class StudentC
		StudentC.noOfStudents++; 

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Richardson";
		student1.firstName = "Valerie";
		student1.studentID = 111111;
		student1.age = 18;
		student1.academicLevel = 1; 

		/*Create another student by calling its default constructor StudentC. 
		 * Increment the static member variable. Assign values to member variables for this instance
		 * of students. student2 is an second instance or an object. 
		 */
		StudentC student2 = new StudentC (); 
		StudentC.noOfStudents++;

		student2.lastName = "Peterson";
		student2.firstName = "Luke";
		student2.studentID = 222222;
		student2.age = 19;
		student2.academicLevel = 1;

		//print the member variables of the two instances of StudentC class
		System.out.println ("We have created " + StudentC.noOfStudents + " instances of class StudentC.\n");
		System.out.println ("Last\tFirst\tID\tAge\tYear"); 

		//We print the student details. 
		//The calls look a little awkward, but we can make them look nicer with "this" later. 
		System.out.println (student1.toString ());		
		System.out.println (student2.toString ());	
	}
}
