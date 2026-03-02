package logicbuilding;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		swapTwoNumbers_1(5, 6);
		swapTwoNumbers_2(5, 6);
		swapTwoNumbers_3(5, 6);
		swapTwoNumbers_4(5, 6);
		swapTwoNumbers_5(5, 6);

	}

	private static void swapTwoNumbers_1(int i, int j) {
		int temp;
		temp = i;
		i = j;
		j = temp;
		System.out.println(" i : " + i + "  and j : " + j);
	}

	private static void swapTwoNumbers_2(int i, int j) {
		i = i + j;
		j = i - j;
		i = i - j;
		System.out.println(" i : " + i + "  and j : " + j);
	}

	private static void swapTwoNumbers_3(int i, int j) {
		i = i * j;
		j = i / j;
		i = i / j;
		System.out.println(" i : " + i + "  and j : " + j);
	}

	private static void swapTwoNumbers_4(int i, int j) {
		i = i ^ j;
		j = i ^ j;
		i = i ^ j;
		System.out.println(" i : " + i + "  and j : " + j);
	}

	private static void swapTwoNumbers_5(int i, int j) {
		j = i + j - (i = j);
		System.out.println(" i : " + i + "  and j : " + j);
	}

}
