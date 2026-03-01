package logicbuilding;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {
		int number = 17;
		int numberOfTrailingZeros = findTheTrailingZerosInFactorial_Optimised(number);
		System.out.println("Number of Trailing zero's are :  " + numberOfTrailingZeros);
	}

	private static int findTheTrailingZerosInFactorial_Optimised(int num) {
		if (num < 0)
			throw new IllegalArgumentException("n must be greater than 0");
		int count = 0;
		int temp = num;
		while (temp > 0) {
			temp = temp / 5;
			count += temp;
		}
		return count;
	}
}