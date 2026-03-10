package dsa_notes_practise.basicproblems;

public class FindSecondLargest {

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1, 4, 17, 9, 0};
        int secondMaxElementInAnArray = findSecondMaxElementInAnArray(arr);
        System.out.println("secondMaxElementInAnArray: " + secondMaxElementInAnArray);
    }

    private static int findSecondMaxElementInAnArray(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;

    }
}
