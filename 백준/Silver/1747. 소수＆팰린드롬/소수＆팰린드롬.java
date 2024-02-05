import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(2);
            return;
        }

        if (N <= 3) {
            System.out.println(N);
            return;
        }

        for (int i = N; i <= 1111111; i++) {
            if (!isPrimeNumber(i)) continue;
            if (!isPalindrome(i)) continue;

            System.out.println(i);
            break;
        }

    }

    private static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        int mid = length / 2;

        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) return false;
        }

        return true;
    }

    private static boolean isPrimeNumber(int n) {
        int exp = (int) Math.sqrt(n);
        for (int i = 2; i <= exp; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}