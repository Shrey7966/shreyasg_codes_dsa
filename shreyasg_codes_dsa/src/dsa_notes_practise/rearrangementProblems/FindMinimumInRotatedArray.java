package dsa_notes_practise.rearrangementProblems;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};

        int min = findMinimum(arr);
        System.out.println("Minimum -> " + min);

    }

    private static int findMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[right]) {
                // there is no drop in the right
                right = mid;
            } else {
                //drop is in left
                left = mid + 1;
            }

        }
        return arr[left];
    }
}
