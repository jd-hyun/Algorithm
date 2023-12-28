import java.io.*;
import java.util.*;

public class Main {
    static int[] sequence;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];
        visited = new boolean[N];

        dfs(0, 0);
    }

    private static void dfs(int depth, int temp) {
        if (depth == M) {
            for (int i : sequence) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && (i + 1) > temp) {
                visited[i] = true;
                sequence[depth] = i + 1;
                temp = i + 1;
                dfs(depth + 1, temp);
                visited[i] = false;
            }
        }
    }
}