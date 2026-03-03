package logicbuilding;

public class NearestNumber {

    public static void main(String[] args) {
        int nearestNumber = findNearestNumber(13, 4);
        System.out.println("nearest number " + nearestNumber);
    }

    private static int findNearestNumber(int target, int divisor) {

        int quotient = target / divisor;

        int lower_multiple = quotient * divisor;

        boolean sameSign = (target > 0) == (divisor > 0);
        int higher_multiple = divisor * (sameSign ? (quotient + 1) : (quotient - 1));

        int d1 = Math.abs(target - lower_multiple);
        int d2 = Math.abs(target - higher_multiple);

        if (d1 < d2) return lower_multiple;
        if (d2 < d1) return higher_multiple;
        return Math.max(lower_multiple, higher_multiple);


    }
}
