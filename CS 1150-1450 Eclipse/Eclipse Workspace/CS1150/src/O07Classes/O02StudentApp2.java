package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentA and another "main" class to 
 * 			create instance/object students
 * Date modified: 11/14/2019
 */

/*We define a class/template called StudentA.
 *This class has no accessibility modifier in front of its name. 
 *If it has no accessibility modifier, it is visible to class and package. 
 *
 *It is a very simple class. A class is a template to create instances. 
 *This class has only properties (a class can also have methods). 
 *Each new instance of a student may have different values for these properties.
 *We can have various types of information in one class: two pieces
 *of String info, and two pieces of int info. 
 */
class StudentA{  //a class that doesn't have public in front of it can be seen
	//in the package only. 
	//These are called class instance members or fields or attributes or properties
	String lastName;
	String firstName;
	int studentID, age, academicLevel; 	
}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * A public class can be seen from any package. A class without a public
 * modifier can be seen within its package only. 
 * 
 */
public class O02StudentApp2 { //A class with public visibility can be seen from
	//all packages in the same project. 
	//A visible class in another package still needs 
	//to be imported.
	//The methods can have visibility modifiers too; 
	//we will talk about only public modifiers for
	//methods now. 

	public static void main (String[] args){

		/*Create a student instance by calling its default constructor StudentA, 
		 * the same name as the class. Assign values to member variables for this instance
		 * of students. student1 is an instance or an object. 
		 */
		StudentA student1;
		student1 = new StudentA(); //Each class has a default 
		//no-arg constructor

		student1.lastName = "Richardson";
		student1.firstName = "Valerie";
		student1.studentID = 111111;
		student1.age = 18;
		student1.academicLevel = 1; 

		/*Create another student instance by calling its default constructor "StudentA", 
		 * the same name as the class. Assign values to member variables for this instance
		 * of students. student2 is an second instance or an object. 
		 */
		StudentA student2 = new StudentA (); 
		student2.lastName = "Peterson";
		student2.firstName = "Luke";
		student2.studentID = 222222;
		student2.age = 19;
		student2.academicLevel = 1;

		//print the member variables of the two instances of StudentA class
		System.out.println ("Last\t\tFirst\tID\tAge\tYear"); 
		System.out.printf ("%s\t%s\t%d\t%d\t%d\n", student1.lastName, student1.firstName, 
				student1.studentID, student1.age, student1.academicLevel);
		System.out.printf ("%s\t%s\t%d\t%d\t%d\n", student2.lastName, student2.firstName, 
				student2.studentID, student2.age, student2.academicLevel);

	}
}
