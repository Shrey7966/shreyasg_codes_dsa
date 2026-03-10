package dsa_notes_practise.rearrangementProblems;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 5, 0};

        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void moveZerosToEnd(int[] arr) {

        int j = 0;
        for (int i = 0; i < arr.length; i++) { // {1, 0, 2, 0, 5, 0}
            if (arr[i] != 0) { //i=3
                int temp = arr[i]; // 2
                arr[i] = arr[j]; // 0
                arr[j] = temp; // 2
                j++; // j =3
            }

        }
    }
}
