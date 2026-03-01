package logicbuilding;

public class EvenOrOdd {

	public static void main(String[] args) {
		System.out.println(findEvenOrOdd(37));
	}

	private static String findEvenOrOdd(int num) {
		return (num&1)==0 ? "Even": "Odd";
	}
}
