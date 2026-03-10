package dsa_notes_practise.rearrangementProblems;

import java.util.Arrays;

public class SeparateEvenAndOddNumbers {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        separateEvenAndOddNumbers(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void separateEvenAndOddNumbers(int[] arr) {

        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
