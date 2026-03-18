package easyproblems;

public class FirstOccaranceOfNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 1, 4};
        int result = firstOccaranceOfNumber(arr, 4);
        System.out.println(result);

    }

    private static int firstOccaranceOfNumber(int[] arr, int i) {

        for (int j = 0; j < arr.length; j++) {

            if (arr[j] == i) {
                return j;
            }
        }
        return -1;
    }
}
