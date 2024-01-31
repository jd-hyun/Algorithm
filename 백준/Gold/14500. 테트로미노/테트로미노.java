import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int maxSum = 0;

    static int[][] paper;

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(maxSum);
    }

    static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        if ((row - 1) >= 0 && !visited[row - 1][col]) {
            if (count == 2) {
                visited[row - 1][col] = true;
                dfs(row, col, sum + paper[row - 1][col], count + 1);
                visited[row - 1][col] = false;
            }
            visited[row - 1][col] = true;
            dfs(row - 1, col, sum + paper[row - 1][col], count + 1);
            visited[row - 1][col] = false;
        }
        if ((row + 1) < N && !visited[row + 1][col]) {
            if (count == 2) {
                visited[row + 1][col] = true;
                dfs(row, col, sum + paper[row + 1][col], count + 1);
                visited[row + 1][col] = false;
            }
            visited[row + 1][col] = true;
            dfs(row + 1, col, sum + paper[row + 1][col], count + 1);
            visited[row + 1][col] = false;
        }
        if ((col - 1) >= 0 && !visited[row][col - 1]) {
            if (count == 2) {
                visited[row][col - 1] = true;
                dfs(row, col, sum + paper[row][col - 1], count + 1);
                visited[row][col - 1] = false;
            }
            visited[row][col - 1] = true;
            dfs(row, col - 1, sum + paper[row][col - 1], count + 1);
            visited[row][col - 1] = false;
        }
        if ((col + 1) < M && !visited[row][col + 1]) {
            if (count == 2) {
                visited[row][col + 1] = true;
                dfs(row, col, sum + paper[row][col + 1], count + 1);
                visited[row][col + 1] = false;
            }
            visited[row][col + 1] = true;
            dfs(row, col + 1, sum + paper[row][col + 1], count + 1);
            visited[row][col + 1] = false;
        }
    }
}