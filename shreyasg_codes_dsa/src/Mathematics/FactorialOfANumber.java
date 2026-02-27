package Mathematics;

public class FactorialOfANumber {

	public static void main(String[] args) {

		System.out.println(calculateFactorialOfANumber(4));
		System.out.println(calculateFactorialOfANumber_optimised(4));

	}

	private static int calculateFactorialOfANumber_optimised(int i) {
		 if (i==0) return 1;
		 int fact =1;
		 for (int k=2;k<=i;k++) {
			 fact *=k;
		 }
		 System.out.println("calculateFactorialOfANumber_optimised: "+ i );
		return fact;
	}

	private static int calculateFactorialOfANumber(int i) {
		int fact = 1;
		while (i > 0) {

			fact *= i;
			i--;
		}
		System.out.println("calculateFactorialOfANumber: "+ i );

		return fact;

	}

}
