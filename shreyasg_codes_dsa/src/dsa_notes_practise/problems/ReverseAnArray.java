package dsa_notes_practise.problems;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] given = {1, 2, 3, 4, 5};
        int[] given1 = reverseTheGivenArray(given);

        for (int num : given1) {
            System.out.println(num);
        }
    }

    private static int[] reverseTheGivenArray(int[] given) {
        int left = 0;
        int right = given.length - 1;

        while (right > left) {
            int temp = given[right];
            given[right] = given[left];
            given[left] = temp;
            left++;
            right--;
        }
        return given;

    }
}
