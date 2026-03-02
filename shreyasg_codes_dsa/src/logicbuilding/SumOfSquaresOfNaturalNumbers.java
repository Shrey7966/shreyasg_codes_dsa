package logicbuilding;

public class SumOfSquaresOfNaturalNumbers {

	public static void main(String[] args) {

		int sumOfSquareOfNaturalNumbers = findSumOfSquareOfNaturalNumbers(8);
		int sumOfSquareOfNaturalNumbers_optimised = findSumOfSquareOfNaturalNumbers_optimised(8);
		System.out.println(sumOfSquareOfNaturalNumbers);
		System.out.println(sumOfSquareOfNaturalNumbers_optimised);

	}

	private static int findSumOfSquareOfNaturalNumbers(int num) {

		int sum = 0;
		for (int i = 0; i <= num; i++) {
			sum = sum + (i * i);
		}
		return sum;
	}

	private static int findSumOfSquareOfNaturalNumbers_optimised(int num) {
		return num * (num + 1) * (2 * num + 1) / 6;
	}

}
