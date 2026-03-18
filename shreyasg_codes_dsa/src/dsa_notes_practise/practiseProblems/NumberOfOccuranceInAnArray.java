package easyproblems;

public class NumberOfOccuranceInAnArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4, 1, 2};

        int result = countNumberOfOccranceOf(arr, 6);
        System.out.println(result);
    }

    private static int countNumberOfOccranceOf(int[] arr, int target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }
}
