package logicbuilding;

public class OppositeFaceOfDice {

    public static void main(String[] args) {

        int answer = oppositeFaceOfDice(5);
        System.out.println("Opposite side is "+ answer);
    }

    private static int oppositeFaceOfDice(int i) {
    // “In a standard dice, opposite faces always sum to 7.
        // So subtracting the given face value from 7 directly gives the opposite face.”
        if (i < 1 || i > 6) {
            throw new IllegalArgumentException("Dice value must be between 1 and 6");
        }
        return 7 - i;
    }
}
