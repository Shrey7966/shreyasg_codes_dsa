package dsa_notes_practise.basicproblems;

public class FindAverageOfArray {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 6, 6};
        double averageOfArray = findAverageOfArray(arr);
        System.out.println("averageOfArray -> " + averageOfArray);
    }

    private static double findAverageOfArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avg = (double) sum / arr.length;
        return avg;
    }


}
