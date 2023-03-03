import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] dp = new int[N][10];

        if (N == 1) {
            System.out.println(10);
        } else if (N == 2) {
            System.out.println(55);
        } else {
            for (int i = 0; i < 10; i++) {
                dp[1][i] = i + 1;
            }


            for (int i = 2; i < N; i++) {
                dp[i][0] = 1;
                for (int j = 1; j < 10; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    dp[i][j] %= 10007;
                }
            }
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += dp[N - 1][i];
            }
            System.out.println(sum % 10007);
        }
    }
}