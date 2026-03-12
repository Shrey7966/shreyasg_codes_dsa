package dsa_notes_practise.rearrangementProblems;

import java.util.Arrays;

public class RotateArrayLeftByKPositions {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        rotateLeft(arr, k);

        System.out.println(Arrays.toString(arr));
    }

    private static void rotateLeft(int[] arr, int k) {

        int n = arr.length;

        k = k % n;   // handle k > n

        reverse(arr, 0, k - 1);     // reverse first k elements
        reverse(arr, k, n - 1);     // reverse remaining elements
        reverse(arr, 0, n - 1);     // reverse entire array
    }

    private static void reverse(int[] arr, int left, int right) {

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}