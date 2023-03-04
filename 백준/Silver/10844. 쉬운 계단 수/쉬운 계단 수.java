import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] dp = new long[N][10];
        dp[0][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 1000000000;
            }
            dp[i][9] = dp[i - 1][8] % 1000000000;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N - 1][i];
        }
        System.out.println(sum % 1000000000);
        scanner.close();
    }
}