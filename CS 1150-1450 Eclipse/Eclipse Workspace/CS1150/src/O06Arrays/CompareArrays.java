package O06Arrays;

public class CompareArrays {
	
	public static void main(String[] args) {
		//create two arrays
		int[] anArray = {1, 2, 3, 4, 5, 6};
		int[] anotherArray = {1, 2, 3, 4, 5, 6};
		
		//compare two arrays
		if (isEqual(anArray, anotherArray) == true)
			System.out.println("The two arrays are the same.");
		else
			System.out.println("The two arrays are different.");
	}
	
	public static boolean isEqual(int[] array1, int[] array2) {
		if(array1.length != array2.length)
			return false;
		for(int i=0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
		return true;
	}

}
