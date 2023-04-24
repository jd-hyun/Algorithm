import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i  = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i; j++) {
                int temp = dp[i - j] + arr[j - 1];
                if (dp[i] < temp) {
                    dp[i] = temp;
                }
            }
            dp[i] = Math.max(dp[i], arr[i]);
        }

        System.out.println(dp[N - 1]);
    }
}