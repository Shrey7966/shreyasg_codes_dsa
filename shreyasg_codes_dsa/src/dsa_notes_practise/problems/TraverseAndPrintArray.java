package dsa_notes_practise.problems;

public class TraverseAndPrintArray {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 59};
        traverseAndPrintArray(arr);
    }

    private static void traverseAndPrintArray(int[] arr) {
        for (int e : arr) {
            System.out.println(e);
        }
    }

}
