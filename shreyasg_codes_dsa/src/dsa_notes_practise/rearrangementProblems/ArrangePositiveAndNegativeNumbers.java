package dsa_notes_practise.rearrangementProblems;

import java.util.Arrays;

public class ArrangePositiveAndNegativeNumbers {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};
        arrangePositiveAndNegativeNumbers(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void arrangePositiveAndNegativeNumbers(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
