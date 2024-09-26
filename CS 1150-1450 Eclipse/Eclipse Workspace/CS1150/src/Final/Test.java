package Final;

public class Test {

	public static void main(String[] args) {
		int[] list1 = {1, 2, 3, 4, 5, 6};

		list1 = reverse(list1);
		for(int i=0; i<list1.length; i++)
			System.out.println(list1[i]);
	}

	public static int[] reverse(int[] list) {

		int[] result = new int[list.length];

		for (int i = 0, j = result.length - 1;i < list.length; i++, j--) {

			result[j] = list[i];

		}

		return result;

	}

}

