package logicbuilding;

public class PalindromeOrNot {

	public static void main(String[] args) {

		System.out.println(checkNumberPalindromeOrNot(1221));
		System.out.println(checkNumberPalindromeOrNot_optimised(1221));

	}

	private static boolean checkNumberPalindromeOrNot_optimised(int num) {
		int rev_half = 0;

		while (num > rev_half) {

			rev_half = rev_half * 10 + num % 10;
			num /= 10;

		}

		return (num == rev_half) || (num == (rev_half/10));
	}

	private static boolean checkNumberPalindromeOrNot(int num) {
		int rev = 0;
		int temp = num;
		while (num != 0) {
			rev = rev * 10 + num % 10; // 0 + 1 = 1 ; 10+2 = 12; 120+2 = 122 ; 1220+1 = 1221
			num = num / 10; // 122, 12
		}

		if (rev == temp)
			return true;

		return false;

	}

}
