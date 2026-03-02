package logicbuilding;

public class sumOfNaturalNumbers {

	public static void main(String[] args) {

		findTheSumOfNaturalNumbers(2);
		int theSumOfNaturalNumbers_Optimized = findTheSumOfNaturalNumbers_Optimized(2);
		System.out.println(theSumOfNaturalNumbers_Optimized);

	}

	private static void findTheSumOfNaturalNumbers(int num) {
		int sum = 0;

		for (int i = 0; i <= num; i++) {
			sum += i;
		}

		System.out.println(sum);
	}

	private static int findTheSumOfNaturalNumbers_Optimized(int num) {
		return num * (num + 1) / 2;
	}

}
