package logicbuilding;

public class MultiplicationTable {

	public static void main(String[] args) {
		multiplicationTable(9,10);
	}

	private static void multiplicationTable(int n, int limit) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + " = " + i * n);
		}

	}
}
