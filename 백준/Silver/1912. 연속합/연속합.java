import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int sum = dp[0];
        if (sum < 0) sum = 0;
        for (int i = 1; i < N; i++) {
            int temp = dp[i];
            if ((temp + sum) > dp[i - 1]) {
                dp[i] += sum;
            }
            else {
                dp[i] = dp[i - 1];
            }

            if ((sum + temp) < 0) {
                sum = 0;
            }

            else {
                sum += temp;
            }
        }

        System.out.println(dp[N - 1]);
    }
}