package easyproblems;

public class SecondLargest {



    public static void main(String[] args) {
        int[] arr = {12,3,16,7,12,9};

        findSecondLargest(arr);

    }

    private static void findSecondLargest(int[] arr) {

        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        System.out.println("Largest: " + max);
        System.out.println("Second Largest: " + secondMax);
    }
}
