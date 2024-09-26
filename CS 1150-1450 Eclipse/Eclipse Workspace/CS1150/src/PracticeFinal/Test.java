package PracticeFinal;

public class Test {

	int i;

	static int s;

	public static void main(String[] args) {

		Test f1 = new Test();

		System.out.println("f1.i is " + f1.i + " f1.s is " + f1.s);

		Test f2 = new Test();

		System.out.println("f2.i is " + f2.i + " f2.s is " + f2.s);

		Test f3 = new Test();

		System.out.println("f3.i is " + f3.i + " f3.s is " + f3.s);
	}
	public Test() {

	    i++;

	    s++;

	  }
}
