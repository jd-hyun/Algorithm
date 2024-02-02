import java.io.*;
import java.util.*;

class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M, H;

    static int[][] box;

    static boolean[][] visited;

    static Queue<Point> queue;

    static int minDay = 0;

    static int[] dx;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N * H][M];
        queue = new LinkedList<>();
        visited = new boolean[N * H][M];
        dx = new int[]{-1, 1, 0, 0, -N, N};
        dy = new int[]{0, 0, -1, 1, 0, 0};

        for (int i = 0; i < (N * H); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) queue.add(new Point(i, j));
            }
        }

        if (!checkZero()) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            minDay += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int x = point.getX();
                int y = point.getY();

                for (int j = 0; j < 6; j++) {
                    if (j == 0) {
                        if (x % N == 0) continue;
                    }

                    if (j == 1) {
                        if ((x + 1) % N == 0) continue;
                    }

                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if (newX < 0 || newX >= (N * H) || newY < 0 || newY >= M) continue;
                    if (visited[newX][newY] || box[newX][newY] != 0) continue;

                    visited[newX][newY] = true;
                    box[newX][newY] = 1;
                    queue.add(new Point(newX, newY));
                }
            }

            if (!checkZero()) {
                System.out.println(minDay);
                return;
            }
        }
        System.out.println(-1);
    }

    static boolean checkZero() {
        for (int[] ints : box) {
            for (int i : ints) {
                if (i == 0) return true;
            }
        }
        return false;
    }
}