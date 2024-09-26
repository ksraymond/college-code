package Teaching;

public class LinearAlgebra {

	public static void main(String args[]) {
		question1();
		//question2();
		//question3();
		
	} //end main
	
	public static void question1() {
		int lim = 100;
		double series1 = 0;
		double series2 = 0;
		double series3 = 0;
		
		for(int i = 0; i<lim; i++) {
			series1 = series1+(i+1);
		}
		System.out.println(series1);
		
		for(int i=0; i<lim; i++) {
			series2 = series2+((i+1)*(i+1));
		}
		System.out.println(series2);
		
		for(int i=0; i<lim; i++ ) {
			series3 = series3+((i+1)*(i+1)*(i+1));
		}
		System.out.println(series3);
	}
	
	public static void question2() {
		double[][] hilbert = new double[13][13];
		double denom;
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<13; j++) {
				denom = (((i+1) + (j+1)) - 1);
				hilbert[i][j] = (1/denom);
			}
		}
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<13; j++) {
				System.out.printf("%f\t", hilbert[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void question3() {
		int odd[] = new int[50];
		int even[] = new int[50];
		
		int evenCount = 0;
		int oddCount = 0;
		
		for(int i=0; i<100; i++) {
			if(i%2 == 0) {
				even[evenCount] = i;
				evenCount++;
			}
			else {
				odd[oddCount] = i;
				oddCount++;
			}
		}
		
		System.out.println("Evens");
		for(int i=0; i<even.length; i++) {
			System.out.println(even[i]);
		}
		
		System.out.println("Odds");
		for(int i=0; i<odd.length; i++) {
			System.out.println(odd[i]);
		}
	}
	
}