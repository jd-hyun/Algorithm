import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------
         *
         * Your code should return true if the two strings are anagrams of each other.
         *
         * */

        int length1 = first.length();
        int length2 = second.length();

        if (length1 != length2) return false;

        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (int i = 0; i < length1; i++) {
            array1[first.charAt(i) - 97]++;
            array2[second.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) return false;
        }

        return true;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
