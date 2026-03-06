package easyproblems;

public class IsPrime {

    public static void main(String[] args) {

        System.out.println("isNumberPrime ->  " +isNumberPrime(19));
        System.out.println("isNumberPrime_optimised ->  "+isNumberPrime_optimised(19));
    }

    private static String isNumberPrime(int num) {
        int count = 0;

        if (num <= 0) return "Enter number greater than 0";

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count == 2 ? num + " is Prime" : num + " is not Prime";
    }

    private static boolean isNumberPrime_optimised(int num) {
        int count = 0;

        if (num <= 0) return false;

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
               return false;
            }
        }
        return true;
    }

}
