package dsa_notes_practise.rearrangementProblems;

public class SearchTargetWithDuplicatesInSortedAndRotatedArray {

    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 1, 1};

        boolean isTargetPresent = searchTargetWithDuplicatesInSortedAndRotatedArray(arr, 6);
        System.out.println("isTargetPresent-> " + isTargetPresent);
    }

    private static boolean searchTargetWithDuplicatesInSortedAndRotatedArray(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) return true;

            if (arr[left] == arr[mid] && arr[right] == arr[mid]) {
                left = left + 1;
                right = right - 1;
            } else if (arr[left] <= arr[mid]) {
                // search left
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    // search right
                    left = mid + 1;
                }
            } else {
                // search right

                if (arr[right] >= target && target > arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return false;
    }
}
