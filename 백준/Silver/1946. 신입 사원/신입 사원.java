import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] ranking = new int[N][2];
            for (int j = 0; j < N; j++) {
                String s = bf.readLine();
                StringTokenizer st = new StringTokenizer(s, " ");
                ranking[j][0] = Integer.parseInt(st.nextToken());
                ranking[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ranking, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int cnt = 1;
            int tmp = ranking[0][1];

            for (int j = 1; j < N; j++) {
                if (ranking[j][1] < tmp) {
                    cnt++;
                    tmp = ranking[j][1];
                }
            }
            System.out.println(cnt);
        }
    }
}