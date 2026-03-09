package dsa_notes_practise.problems;

public class FindSecondSmallest {

    public static void main(String[] args) {

        int[] arr = {8, 6, 5, 0, 2, 9};
        int secondSmallestArray = findSecondSmallestArray(arr);
        System.out.println("secondSmallestArray : " + secondSmallestArray);

    }

    private static int findSecondSmallestArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {

            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num != min) {
                secondMin = num;
            }
        }

        return secondMin;
    }
}
