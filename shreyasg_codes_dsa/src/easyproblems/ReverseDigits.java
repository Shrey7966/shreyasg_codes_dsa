package easyproblems;

public class ReverseDigits {

    public static void main(String[] args) {

        int reverse  = reverseTheDigits(54321);
        System.out.println("reverseTheDigits : "+reverse);
        System.out.println("reverseTheDigits_optimised : " + reverseTheDigits_optimised(54321, 0));

    }
    private static int reverseTheDigits(int num) {
        int rem = 0;
        while(num>0){
            rem = num%10 + 10*rem;
            num = num/10;
        }
        return rem;

    }
    private static int reverseTheDigits_optimised(int num, int rev) {
        if(num==0) return rev;
        return reverseTheDigits_optimised(num/10, num%10 + 10*rev);
    }
}
