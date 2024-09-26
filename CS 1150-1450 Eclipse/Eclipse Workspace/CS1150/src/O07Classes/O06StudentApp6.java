package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentE and another "main" class to 
 * 			create instance/object students. Show use of static member variables
 * 			and member methods. Define a number of constructors for the class.
 * 			In the main class, use a foreach loop to go over each element of an array
 * 			students.  
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentE.*/
class StudentE{  //We can have only one class with a specific name within a package
	String lastName;
	String firstName;
	int studentID, age, academicLevel; 	

	//A static field 
	static int noOfStudents = 0; 

	//If we define any constructor at all, the default one is no longer available.
	//If we want to use the default one, we have to redefine it like below. 
	StudentE (){
		StudentE.noOfStudents++;
	}

	//Define another constructor to override the default constructor called StudentE
	//Provide last name and first name when creating an instance
	StudentE (String lName, String fName){
		StudentE.noOfStudents++;
		this.lastName = lName;
		this.firstName = fName;		
	}

	//Define another constructor when we know the student's ID and academicLevel
	StudentE (int ID, int level){
		//the StudentE class doesn't have to be specified but good idea to do so
		noOfStudents++; 
		this.studentID = ID;
		this.academicLevel = level; 
	}


	//A member method to print details of a student
	public String toString (){
		return String.format ("%-12s%-10s\t%d\t%d\t%d", this.lastName, this.firstName, 
				this.studentID, this.age, this.academicLevel);
	}


}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O06StudentApp6 {

	public static void main (String[] args){

		//Create a student by calling its default constructor "StudentE", 
		StudentE student1 = new StudentE (); 

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Reuter";
		student1.firstName = "Jack";
		student1.studentID = 111111;
		student1.age = 18;
		student1.academicLevel = 1; 

		/*Create another student by calling its second constructor. 
		 * Increment the static member variable. Assign values to member variables for this instance
		 * of students. student2 is an second instance or an object. 
		 */
		StudentE student2 = new StudentE ("Richardson", "Valerie"); 

		//Assign values to member variables 
		student2.studentID = 222222;
		student2.age = 19;
		student2.academicLevel = 1;


		/*Create a third student by calling its third constructor. 
		 */
		StudentE student3 = new StudentE (333333, 2); 

		//Assign values to member variables 
		student3.lastName = "Peterson";
		student3.firstName = "Luke";
		student3.age = 19; 

		//an array of  objects of type StudentE 
		StudentE[] students = {student1, student2, student3};

		//print the member variables of the two instances of StudentE class
		System.out.println ("We have created " + StudentE.noOfStudents + " instances of class StudentE.\n");
		System.out.println ("Last\t    First\tID\tAge\tYear"); 

		//We print the student details by using a foreach loop over the array students
		for (StudentE s:students){
			System.out.println (s.toString ());		
		}

	}
}
