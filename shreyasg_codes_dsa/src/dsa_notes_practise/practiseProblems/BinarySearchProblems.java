package dsa_notes_practise.practiseProblems;

public class BinarySearchProblems {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 70, 90, 99, 100, 110, 111, 121};

        System.out.println(findTheNumberUsingBinarySearch(arr, 50));

    }

    private static String findTheNumberUsingBinarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return "Found : " + target;

            if (arr[mid] < target) {
                //search right side
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return target + " > Not found";
    }
}
