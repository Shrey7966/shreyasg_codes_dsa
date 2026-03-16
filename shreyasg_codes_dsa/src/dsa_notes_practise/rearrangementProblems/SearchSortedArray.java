package dsa_notes_practise.rearrangementProblems;

public class SearchSortedArray {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 1, 2, 3, 4, 5};
        int target = 9;

        int result = searchSorted(arr, target);
        System.out.println(result);
    }

    private static int searchSorted(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;

            if (arr[left] < arr[mid]) {
                //left is sorted
                if (target >= arr[left] && target < mid) {
                    //search left
                    right = mid - 1;
                } else {
                    //search right
                    left = mid + 1;
                }

            } else {
                //right is sorted
                if (target <= arr[right] && target > arr[mid]) {
                    // search right
                    left = mid + 1;
                } else {
                    //search left
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


}
