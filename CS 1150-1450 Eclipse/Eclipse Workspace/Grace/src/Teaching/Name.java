package Teaching;

/* random
 * 
 * returns a random double from [0, 1)
 * casting
 * min to max
 */

public class Name {
	public static void main(String args[]) {

		int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		
		boolean isZero = false;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0)
				isZero = true;
		}
		
		if(!isZero)
			System.out.println("There is not at least 1 zero in the array");
		else
			System.out.println("There are zeroes in the array");
		
	}
}