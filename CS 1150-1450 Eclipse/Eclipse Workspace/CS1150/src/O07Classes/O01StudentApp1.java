package O07Classes; 

/* Programmer: Yanyan Zhuang
 * Class: CS 1150
 * Purpose: Tries to store information about a student in several arrays
 * Date modified: 11/14/2019
 */

public class O01StudentApp1 {

	public static void main (String[] args){

		/* We want to store several pieces of information about a student
		 * in an array, and soon find that it's awkward to store 
		 * various types of information. Because we can store only similar
		 * types of information in an array, we may need to use several 
		 * arrays and remember what information is stored in which array and in
		 * which position.  
		 */


		//We store all String info in String arrays: last name, and first name
		String[] studentName1 = {"Richardson", "Valerie"};
		String[] studentName2 = {"Peterson", "Luke"};
		//We store the int information in int arrays: 
		//	ID, age, academicLevel. Each piece is int. We need an
		//additional array to store this information
		int[] studentInfo1 = {111111, 18, 1}; 
		int[] studentInfo2 = {222222, 19, 1}; 
		//If we have other types of information about students, we will 
		//have to store in other types of arrays. E.g., GPA information 
		//semester by semester. This info is double. 

		//Alternatively, we can have five arrays: firstNames[], lastNames[],
		//IDs[], ages[], years[]
		// String[] firstNames = {"Valerie", "Luke"};
		// String[] lastNames = {"Richardson", "Peterson"};
		// int[] IDs = {11111, 222222};
		// int[] ages ={18, 19};
		// int[] years = {1, 1};

		//print the member variables of the two instances of StudentA class
		System.out.println ("Last\t\tFirst\tID\tAge\tYear"); 
		System.out.printf ("%s\t%s\t%d\t%d\t%d\n", 
				studentName1[0], studentName1[1], studentInfo1[0],
				studentInfo1[1], studentInfo1[2]);
		System.out.printf ("%s\t%s\t%d\t%d\t%d\n", 
				studentName2[0], studentName2[1], studentInfo2[0],
				studentInfo2[1], studentInfo2[2]);

		// Creating an object from class in a different program
		//StudentA student1;
		//student1 = new StudentA ();
		//System.out.print(student1.firstName);

	}
}

