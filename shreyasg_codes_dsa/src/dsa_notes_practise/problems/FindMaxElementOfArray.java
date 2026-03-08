package dsa_notes_practise.problems;

public class FindMaxElementOfArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 4, 7};
        int maxElement = findMaxElement(arr);
        System.out.println("maxElement -> " + maxElement);
    }

    private static int findMaxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
