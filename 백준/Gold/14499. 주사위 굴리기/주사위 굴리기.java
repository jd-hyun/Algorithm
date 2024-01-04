import java.io.*;
import java.util.*;

public class Main {
    static int x, y;
    static int[] dice;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dice = new int[6];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int command = Integer.parseInt(st.nextToken());
            int temp1, temp2, temp3, temp4;

            switch (command) {
                case 1:
                    if ((y + 1) >= M) break;
                    y++;
                    temp1 = dice[5];
                    temp2 = dice[3];
                    temp3 = dice[0];
                    temp4 = dice[2];
                    dice[3] = temp1;
                    dice[0] = temp2;
                    dice[2] = temp3;
                    dice[5] = temp4;

                    bottomCopy();
                    break;
                case 2:
                    if ((y - 1) < 0) break;
                    y--;
                    temp1 = dice[5];
                    temp2 = dice[3];
                    temp3 = dice[0];
                    temp4 = dice[2];
                    dice[2] = temp1;
                    dice[5] = temp2;
                    dice[3] = temp3;
                    dice[0] = temp4;

                    bottomCopy();
                    break;
                case 3:
                    if ((x - 1) < 0) break;
                    x--;
                    temp1 = dice[5];
                    temp2 = dice[4];
                    temp3 = dice[0];
                    temp4 = dice[1];
                    dice[1] = temp1;
                    dice[5] = temp2;
                    dice[4] = temp3;
                    dice[0] = temp4;

                    bottomCopy();
                    break;
                case 4:
                    if ((x + 1) >= N) break;
                    x++;
                    temp1 = dice[5];
                    temp2 = dice[4];
                    temp3 = dice[0];
                    temp4 = dice[1];
                    dice[4] = temp1;
                    dice[0] = temp2;
                    dice[1] = temp3;
                    dice[5] = temp4;

                    bottomCopy();
                    break;
            }
        }
    }

    private static void bottomCopy() {
        if (map[x][y] == 0) map[x][y] = dice[5];
        else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
        System.out.println(dice[0]);
    }
}