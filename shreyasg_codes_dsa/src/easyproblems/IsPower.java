package easyproblems;

public class IsPower {

    public static void main(String[] args) {
        System.out.println(isPower(27, 3));
    }

    private static boolean isPower(int number, int base) {

        if (number <= 0 || base <= 1) return false;

        while (number % base == 0) {
            number = number / base;
        }
        return number == 1;
    }
}


