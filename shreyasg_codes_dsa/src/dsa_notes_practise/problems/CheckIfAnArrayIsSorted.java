package dsa_notes_practise.problems;

public class CheckIfAnArrayIsSorted {

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1};

        boolean b = checkIfAnArrayIsSorted(arr);
        System.out.println("checkIfAnArrayIsSorted " + b);
    }

    private static boolean checkIfAnArrayIsSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

