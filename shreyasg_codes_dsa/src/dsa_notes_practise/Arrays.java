package dsa_notes_practise;

import java.util.ArrayList;

public class Arrays {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(arr[3]);

        // Traversing an Array

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Using For loop");
            System.out.println(arr[i]);
        }
        System.out.println("Using For Each loop");
        for (int arrayEle : arr) {
            System.out.println(arrayEle);
        }

        // Static vs Dynamic array

        int[] array = new int[5]; //fixed size

        ArrayList<Integer> arraylist = new ArrayList<>();

        arraylist.add(4);
        arraylist.add(6);
        arraylist.add(2);

        System.out.println(arraylist);


        // In place vs Extra space

        int[] input = {1, 2, 3, 4};

        int left = 0;
        int right = input.length - 1;

        while (left < right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;

            left++;
            right--;
        }

        for (int num : input) {
            System.out.println(num);
        }

        // Using extra space

        int[] newarr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            newarr[i] = input[input.length - 1 - i];
        }

        for (int num : newarr) {
            System.out.println( num);
        }
    }
}