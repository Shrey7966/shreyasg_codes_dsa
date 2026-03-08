package dsa_notes_practise.problems;

public class CountTheOccuranceOfElement {

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 4, 6, 6, 7, 7, 7, 7, 3, 1, 1, 2, 2, 1, 1};

        countTheOccuranceOfANumber(arr, 7);
        countTheOccuranceOfANumber(arr, 0);
        countTheOccuranceOfANumber(arr, 1);
        countTheOccuranceOfANumber(arr, 3);
    }

    private static void countTheOccuranceOfANumber(int[] arr, int num) {
        int count = 0;
        for (int i : arr) {
            if (i == num) count++;
        }
        System.out.println("Number " + num + " has appeared " + count + " times in the array ");

    }
}
