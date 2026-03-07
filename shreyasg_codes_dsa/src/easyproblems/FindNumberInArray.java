package easyproblems;

public class FindNumberInArray {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9};
        boolean flag = findNumberInArray(arr, 99);
        System.out.println(flag);
    }

    private static boolean findNumberInArray(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return true;
        }
        return false;
    }
}
