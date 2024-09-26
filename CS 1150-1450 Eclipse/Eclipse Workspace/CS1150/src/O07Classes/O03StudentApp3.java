package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: To define a class called StudentB and another "main" class to 
 * 			create instance/object students. Show use of static member variables. 
 * Date modified: 11/14/2019
 */

class Circle{
	double radius;
	static int numberOfObjects = 0;
}


/* We define a class/template called StudentB.
 * This class has member variables. It also has a static variable or a class variable. 
 * A class variable is common to all instances; in other words, it belongs to the class itself. 
 */

class StudentB{  //We can have only one class with a specific name within a package
	//These are instance variables, i.e., properties of individual instances. 
	String lastName;
	String firstName;
	int studentID, age, academicLevel; 	

	//A static field has only one copy for the entire class. A
	//static field is a property of the class. 
	//In contrast, each instance has a copy of a non-static variable. 
	//A non-static field is a property of an instance of the class. 
	static int noOfStudents = 0; 

}


/*We can have more than one class in a file. But, only one of these classes can
 * have public accessibility modifier. The file has to have the same name as the
 * public class. In this case, our public class has a main method. 
 * 
 */
public class O03StudentApp3 {

	public static void main (String[] args){

		//Circle class
		//Create a circle 
		Circle circle1;
		circle1 = new Circle();
		circle1.radius = 1;

		Circle.numberOfObjects++;
		System.out.println("The radius of circle1: " + circle1.radius + 
				". The number of objects: " + Circle.numberOfObjects);

		//Create another circle 
		Circle circle2;
		circle2 = new Circle();
		circle2.radius = 5;

		Circle.numberOfObjects++;
		System.out.println("The radius of circle2: " + circle2.radius + 
				". The number of objects: " + Circle.numberOfObjects);


		//Student class
		//Create a student by calling its default constructor "StudentB", 
		StudentB student1;
		student1 = new StudentB ();

		//Increment the static member variable for class StudentB
		StudentB.noOfStudents++; 

		//Assign values to member variables for this instance of students. 
		student1.lastName = "Richardson";
		student1.firstName = "Valerie";
		student1.studentID = 111111;
		student1.age = 18;
		student1.academicLevel = 1; 

		/*Create another student by calling its default constructor StudentB. 
		 * Increment the static member variable. Assign values to member variables for this instance
		 * of students. student2 is an second instance or an object. 
		 */
		StudentB student2 = new StudentB (); 
		StudentB.noOfStudents++;

		student2.lastName = "Peterson";
		student2.firstName = "Luke";
		student2.studentID = 222222;
		student2.age = 19;
		student2.academicLevel = 1;


		//print the member variables of the two instances of StudentB class
		System.out.println ("\nWe have created " + StudentB.noOfStudents + " instances of class StudentB.\n");
		System.out.println ("Last\t\tFirst\tID\tAge\tYear"); 
		System.out.printf ("%s\t%s\t%d\t%d\t%d\n", student1.lastName, student1.firstName, 
				student1.studentID, student1.age, student1.academicLevel);
		System.out.printf ("%s\t%s\t%d\t%d\t%d\n", student2.lastName, student2.firstName, 
				student2.studentID, student2.age, student2.academicLevel);	

	}
}
