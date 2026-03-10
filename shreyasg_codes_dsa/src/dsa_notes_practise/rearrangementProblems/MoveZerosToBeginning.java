package dsa_notes_practise.rearrangementProblems;

import java.util.Arrays;

public class MoveZerosToBeginning {

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 5, 0};
        moveZerosToBeginning(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosToBeginning(int[] arr) {

        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

    }
}
