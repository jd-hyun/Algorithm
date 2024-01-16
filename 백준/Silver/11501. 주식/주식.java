import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stocks = new int[N + 1];
            stocks[N] = 0;

            for (int j = 0; j < N; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = stocks[N - 1];
            long maxProfit = 0;
            for (int j = N - 2; j >= 0; j--) {
                if (stocks[j] < maxPrice) {
                    maxProfit += (maxPrice - stocks[j]);
                }
                else if (stocks[j] > stocks[j + 1]) {
                    maxPrice = stocks[j];
                }
            }
            sb.append(maxProfit).append("\n");
        }
        System.out.println(sb);
    }
}