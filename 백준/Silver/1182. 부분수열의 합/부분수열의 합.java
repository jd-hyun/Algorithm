import java.io.*;
import java.util.*;

public class Main {
    static int[] sequence;
    static int N, S;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) count--;

        System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) count++;
            return;
        }

        dfs(depth + 1, sum + sequence[depth]);
        dfs(depth + 1, sum);
    }
}