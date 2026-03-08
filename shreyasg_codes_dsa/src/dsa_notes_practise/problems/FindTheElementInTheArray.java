package dsa_notes_practise.problems;

public class FindTheElementInTheArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 64, 3, 6, 2};
        System.out.println(findTheNumberInArray(arr, 0));
    }

    private static boolean findTheNumberInArray(int[] arr, int num) {
        for (int value : arr) {
            if (value == num) return true;
        }
        return false;
    }
}
