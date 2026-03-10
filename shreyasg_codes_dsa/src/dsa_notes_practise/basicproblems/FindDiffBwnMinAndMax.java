package dsa_notes_practise.basicproblems;

public class FindDiffBwnMinAndMax {

    public static void main(String[] args) {

        int[] arr = {9, 6, 3, 2, 4, 8};

        int theDiffBtnMaxAndMin = findTheDiffBtnMaxAndMin(arr);
        System.out.println("theDiffBtnMaxAndMin -> " + theDiffBtnMaxAndMin);

    }

    private static int findTheDiffBtnMaxAndMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max - min;
    }
}
