package logicbuilding;

public class CountDigits {

	public static void main(String[] args) {

		System.out.println("Number of digits is : " + countNumberOfDigits(2876));

		System.out.println(countNumberOfDigits_optimised(2876));

	}

	public static int countNumberOfDigits(int num) {
		int res = 0;

		while (num != 0) {

			num /= 10;

			res++;
		}
		return res;
	}

	public static int countNumberOfDigits_optimised(int num) {

		if (num == 0)
			return 1;
		return (int) Math.log10(Math.abs(2876)) + 1;
	}

}
