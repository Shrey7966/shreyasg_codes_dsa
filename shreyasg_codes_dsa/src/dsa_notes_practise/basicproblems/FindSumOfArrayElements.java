package dsa_notes_practise.basicproblems;

public class FindSumOfArrayElements {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        int sumOfArray = findSumOfArray(arr);
        System.out.println("sumOfArray -> " + sumOfArray);
    }

    private static int findSumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
