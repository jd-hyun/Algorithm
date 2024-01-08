import java.io.*;
import java.util.*;

public class Main {

    static int N, K, L;
    static boolean[][] board;

    static HashMap<Integer, Character> hashMap;
    static List<Position> snake;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            board[row- 1][column - 1] = true;
        }

        L = Integer.parseInt(br.readLine());
        hashMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hashMap.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        int x = 0;
        int y = 0;
        int time = 0;
        int direction = 0;
        snake = new ArrayList<>();
        snake.add(new Position(x, y));

        while (true) {
            time++;

            x += dx[direction];
            y += dy[direction];

            if (isFinish(x, y)) {
                break;
            }

            snake.add(new Position(x, y));
            if (board[x][y]) {
                board[x][y] = false;
            }
            else {
                snake.remove(0);
            }

            if (hashMap.containsKey(time)) {
                direction = direction + 4;
                if (hashMap.get(time) == 'D') {
                    direction++;
                }
                else {
                    direction--;
                }
                direction %= 4;
            }
        }
        System.out.println(time);
    }

    static boolean isFinish(int x, int y) {
        if (x == -1 || x == N || y == -1 || y == N) return true;

        for (int i = 0; i < snake.size(); i++) {
            Position position = snake.get(i);
            if (position.getX() == x && position.getY() == y) return true;
        }
        return false;
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}