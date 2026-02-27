package primitive_types;

public class ParityOfAWord {

	public static void main(String[] args) {
		
		System.out.println(parity(5));

	}

	public static short parity(long x) {

		short result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x >>>= 1;
		}
		return result;
	}
}
