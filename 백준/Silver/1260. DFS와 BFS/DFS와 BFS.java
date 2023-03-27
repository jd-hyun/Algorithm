import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static StringBuilder sb;
    static boolean[] visited;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();
        sb = new StringBuilder();
        visited = new boolean[N];
        map = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x - 1][y - 1] = true;
            map[y - 1][x - 1] = true;
        }

        dfs(V - 1);
        System.out.println(sb);
        visited = new boolean[N];
        sb = new StringBuilder();
        bfs(V - 1);
    }

    static void dfs(int start) {
        sb.append(start + 1 + " ");
        visited[start] = true;
        for (int i = 0; i < N; i++) {
            if (map[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp + 1 + " ");
            for (int i = 0; i < N; i++) {
                if (map[temp][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(sb);
    }
}