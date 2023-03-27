import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static boolean[] visited;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        visited = new boolean[N];
        map = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x - 1][y - 1] = true;
            map[y - 1][x - 1] = true;
        }
        count = 0;
        bfs(0);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < N; i++) {
                if (map[temp][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}