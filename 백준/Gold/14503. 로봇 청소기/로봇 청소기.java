import java.io.*;
import java.util.*;

public class Main {
    static int N, M, r, c;
    static int[][] room;
    static boolean[][] cleaned;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            if (!cleaned[r][c]) {
                count++;
                cleaned[r][c] = true;
            }

            if (!isClean()) {
                int temp = (d + 2) % 4;
                if (room[r + dx[temp]][c + dy[temp]] == 0) {
                    r += dx[temp];
                    c += dy[temp];
                }
                else break;
            }
            else {
                d = (d + 3) % 4;
                if (room[r + dx[d]][c + dy[d]] == 0 && !cleaned[r + dx[d]][c + dy[d]]) {
                    r += dx[d];
                    c += dy[d];
                }
            }
        }

        System.out.println(count);
    }

    static boolean isClean() {
        if ((r - 1) >= 0) {
            if (room[r - 1][c] == 0 && !cleaned[r - 1][c]) return true;
        }
        if ((c + 1) <= (M - 1)) {
            if (room[r][c + 1] == 0 && !cleaned[r][c + 1]) return true;
        }
        if ((r + 1) <= (N - 1)) {
            if (room[r + 1][c] == 0 && !cleaned[r + 1][c]) return true;
        }
        if ((c - 1) >= 0) {
            if (room[r][c - 1] == 0 && !cleaned[r][c - 1]) return true;
        }
        return false;
    }
}