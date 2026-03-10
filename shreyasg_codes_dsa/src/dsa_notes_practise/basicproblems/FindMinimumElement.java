package dsa_notes_practise.basicproblems;

public class FindMinimumElement {

    public static void main(String[] args) {

        int[] arr = {99, 675, 67, 234, 24, 777};
        int minElement = findMinElement(arr);
        System.out.println("minElement->  " + minElement);

    }

    private static int findMinElement(int[] arr) {

        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
