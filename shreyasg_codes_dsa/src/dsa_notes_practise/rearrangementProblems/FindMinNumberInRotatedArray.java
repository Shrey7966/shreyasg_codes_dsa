package dsa_notes_practise.rearrangementProblems;


public class FindMinNumberInRotatedArray {

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
        int result = findMinElement(arr);
        System.out.println(result);

    }

    public static int findMinElement(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int min = arr[mid];

            if (min > arr[left]) {
                //search left

                if (min >= arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                // search right
                if (min <= arr[right]) {
                    left = mid + 1;
                } else {
                    left = mid - 1;
                }
            }
        }

        return -1;
    }
}
