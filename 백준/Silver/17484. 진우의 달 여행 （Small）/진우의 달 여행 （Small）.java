import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int[][] matrix;

    static boolean[][] visited;

//    static int direction;
    static int minFuel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minFuel = Integer.MAX_VALUE;
        matrix = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(i,1, matrix[0][i], 0);
        }

        System.out.println(minFuel);
    }

    private static void dfs(int col, int depth, int sum, int direction) {
        if (depth == N) {
            minFuel = Math.min(minFuel, sum);
            return;
        }

        if ((col - 1) >= 0 && direction != 1) {
            visited[depth][col - 1] = true;
            dfs(col - 1, depth + 1, sum + matrix[depth][col - 1], 1);
            visited[depth][col - 1] = false;
        }

        if (direction != 2) {
            visited[depth][col] = true;
            dfs(col, depth + 1, sum + matrix[depth][col], 2);
            visited[depth][col] = false;
        }

        if ((col + 1) < M && direction != 3) {
            visited[depth][col + 1] = true;
            dfs(col + 1, depth + 1, sum + matrix[depth][col + 1], 3);
            visited[depth][col + 1] = false;
        }
    }
}