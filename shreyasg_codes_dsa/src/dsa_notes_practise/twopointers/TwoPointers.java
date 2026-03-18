package dsa_notes_practise.twopointers;

public class TwoPointers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findSumofTwoPairs(arr, 8);

    }

    private static void findSumofTwoPairs(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println(arr[left] + " , " + arr[right]);
                left = left + 1;
                right = right - 1;
            } else if (sum < target) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
    }
}
