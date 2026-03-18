package dsa_notes_practise.practiseProblems;

public class LastOccuranceOfANumber {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 4, 1, 2};
        int result = lastOccuranceOfANumber(arr, 3);
        System.out.println(result);

    }

    private static int lastOccuranceOfANumber(int[] arr, int target) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
