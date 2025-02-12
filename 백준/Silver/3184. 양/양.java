import java.io.*;

public class Main {
    static int R, C, sheepCount, wolfCount;

    static char[][] yard;

    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);

        yard = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                yard[i][j] = line.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (yard[i][j] != '#' && !visited[i][j]) {
                    sheepCount = 0;
                    wolfCount = 0;
                    dfs(i, j);
                    if (sheepCount > wolfCount) {
                        sheep += sheepCount;
                    } else {
                        wolf += wolfCount;
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void dfs(int x, int y) {
        switch (yard[x][y]) {
            case 'o':
                sheepCount++;
                break;
            case 'v':
                wolfCount++;
                break;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < R && newY >=0 && newY < C && !visited[newX][newY] && yard[newX][newY] != '#') {
                dfs(newX, newY);
            }
        }
    }
}