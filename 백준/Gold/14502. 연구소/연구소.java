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
    static int N, M;

    static int maxSize = 0;

    static int[][] map;

    static boolean[][] visited;

    static List<Point> list;

    static int[] dx = {-1, 1, 0, 0};

    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }

        buildWall(0);

        System.out.println(maxSize);
    }

    static void spreadVirus(int row, int col, int[][] clone) {
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) continue;

            if (clone[newRow][newCol] != 0) continue;

            clone[newRow][newCol] = 2;
            spreadVirus(newRow, newCol, clone);
        }
    }

    static void buildWall(int count) {
        if (count == 3) {
            int[][] clone = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    clone[i][j] = map[i][j];
                }
            }
            for (Point point : list) {
                int row = point.getX();
                int col = point.getY();
                spreadVirus(row, col, clone);
            }
            int size = 0;
            for (int[] ints : clone) {
                for (int i : ints) {
                    if (i == 0) size++;
                }
            }
            maxSize = Math.max(size, maxSize);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }

    }
}