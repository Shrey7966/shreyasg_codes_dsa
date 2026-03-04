package easyproblems;

public class sumOfDigits {

    public static void main(String[] args) {

        int sumOfDigits = findSumOfDigits(12345);
        System.out.println(sumOfDigits);

        int sumOfDigits_optimised =  findSumOfDigits_optimised(12345);
        System.out.println(sumOfDigits_optimised);
    }

    private static int findSumOfDigits(int num) {
        int sum = 0;
        while(num!=0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    private static int findSumOfDigits_optimised(int num) {
        int sum = 0;
        if(num==0) return 0;

        return num%10 + findSumOfDigits_optimised(num/10);
    }


}
