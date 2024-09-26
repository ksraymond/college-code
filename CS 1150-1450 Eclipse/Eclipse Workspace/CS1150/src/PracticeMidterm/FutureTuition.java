package PracticeMidterm;

/*pseudocode
 * tuition is 12000
 * increases 4% (0.04) every year
 * predict when tuition will be doubled, or equal to 24000
 * double tuition = 12000
 * int year = 0
 * while tuition<=24000
 * tuition = tuition * 1.04
 * year += 1
 * system.out.println the tuition will double in x amount of years
 */
public class FutureTuition {
	public static void main(String[] args) {
		double tuition = 12000;
		int year = 0;
		
		while(tuition<=24000)
		{
			tuition = tuition*1.04;
			year += 1;
		}
		System.out.println("The tuition will double in approximately " + year + " years");
	}

}
