import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visited = new boolean[N][M];
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }
    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y1 = node.y;
            int x1 = node.x;

            if (y1 > 0 && maze[y1 - 1][x1] == 1 && !visited[y1 - 1][x1]) {
                queue.add(new Node(y1 - 1, x1));
                visited[y1 - 1][x1] = true;
                maze[y1 - 1][x1] = maze[y1][x1] + 1;
            }

            if (y1 < N - 1 && maze[y1 + 1][x1] == 1 && !visited[y1 + 1][x1]) {
                queue.add(new Node(y1 + 1, x1));
                visited[y1 + 1][x1] = true;
                maze[y1 + 1][x1] = maze[y1][x1] + 1;
            }

            if (x1 > 0 && maze[y1][x1 - 1] == 1 && !visited[y1][x1 - 1]) {
                queue.add(new Node(y1, x1 - 1));
                visited[y1][x1 - 1] = true;
                maze[y1][x1 - 1] = maze[y1][x1] + 1;
            }

            if (x1 < M - 1 && maze[y1][x1 + 1] == 1 && !visited[y1][x1 + 1]) {
                queue.add(new Node(y1, x1 + 1));
                visited[y1][x1 + 1] = true;
                maze[y1][x1 + 1] = maze[y1][x1] + 1;
            }
        }
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}