import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n, m, targetRow, targetCol;

    static int[][] map, distance;

    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    targetRow = i;
                    targetCol = j;
                }
            }
        }

        bfs(targetRow, targetCol);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) sb.append(-1).append(" ");
                else sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = node.getRow() + dx[i];
                int newCol = node.getCol() + dy[i];

                if (newRow > -1 && newRow < n && newCol > -1 && newCol < m) {
                    if (map[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        queue.add(new Node(newRow, newCol));
                        distance[newRow][newCol] = distance[node.getRow()][node.getCol()] + 1;
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
    }
}

class Node {
    private int row;

    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}