package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentD and another "main" class to 
 * 			create instance/object students. Show use of static member variables, 
 * 			member methods and constructors. 
 * Date modified: 11/14/2019
 */


/*We define a class/template called StudentD.*/
class StudentD{  //We can have only one class with a specific name within a package
	String lastName;
	String firstName;
	int studentID, age, academicLevel; 	

	//A static field 
	static int noOfStudents = 0; 

	//If we define any constructor at all, the default one is no longer available.
	//If we want to use the default one, we have to redefine it like below. 
	//It may have some content inside the body although it has nothing now. 
	public StudentD (){
	}

	//Just like we can construct an object, say a house in different ways, 
	//with different options, we can construct a Java object in different ways.
	//Define another constructor to override the default constructor called StudentD
	//Provide last name and first name when creating an instance
	//The use of 'this' is optional, but its use makes things clearer.  
	public StudentD (String lastName, String firstName){
		this.lastName = lastName;
		this.firstName = firstName;		
	}

	//Define another constructor when we know the student's ID and academicLevel
	public StudentD (int ID, int level){
		this.studentID = ID;
		this.academicLevel = level; 
	}


	//A member method to return details of a student as a String
	public String toString (){
		/*Left justify text
		String.format("|%-30s|", "Hello World"); // prints: |Hello World |*/
		return String.format ("%-12s%-10s\t%d\t%d\t%d", this.lastName, this.firstName, 
				this.studentID, this.age, this.academicLevel);
	}	


}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O05StudentApp5 {

	public static void main (String[] args){

		//Create a student by calling its default constructor "StudentD", 
		//Error if we remove the constructor on line 24
		StudentD student1 = new StudentD ();

		//Increment the static member variable for class Student2
		StudentD.noOfStudents++; 

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Richardson";
		student1.firstName = "Valerie";
		student1.studentID = 111111;
		student1.age = 18;
		student1.academicLevel = 1; 

		/*Create another student by calling its second constructor. 
		 * Increment the static member variable. Assign values to member variables for this instance
		 * of students. student2 is a second instance or an object. 
		 */
		StudentD student2 = new StudentD ("Peterson", "Luke"); 
		StudentD.noOfStudents++;

		//Assign values to member variables 
		student2.studentID = 222222;
		student2.age = 19;
		student2.academicLevel = 1;


		/*Create a third student by calling its third constructor. 
		 */
		StudentD student3 = new StudentD (333333, 2); 
		StudentD.noOfStudents++;

		//Assign values to member variables 
		student3.lastName = "Reuter";
		student3.firstName = "Jack";
		student3.age = 19; 	

		//print the member variables of the two instances of StudentD class
		System.out.println ("We have created " + StudentD.noOfStudents + " instances of class StudentD.\n");
		System.out.println ("Last        First\tID\tAge\tYear"); 

		//We print the student details. 
		//The calls look a little awkward, but we can make them look nicer with "this" later. 
		System.out.println (student1.toString ());		
		System.out.println (student2.toString ());
		System.out.println (student3.toString ());


	}
}
