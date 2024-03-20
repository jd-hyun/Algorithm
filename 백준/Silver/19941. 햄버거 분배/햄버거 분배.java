import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        char[] array = s.toCharArray();
        boolean[] checked = new boolean[N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean ate = false;
            if (array[i] == 'P') {
                for (int j = K; j > 0; j--) {
                    if ((i - j) >= 0) {
                        if (array[i - j] == 'H' && !checked[i - j]) {
                            count += 1;
                            checked[i - j] = true;
                            checked[i] = true;
                            ate = true;
                            break;
                        }
                    }
                }
                if (ate) continue;
                for (int j = 1; j <= K; j++) {
                    if ((i + j) < N) {
                        if (array[i + j] == 'H' && !checked[i + j]) {
                            count += 1;
                            checked[i + j] = true;
                            checked[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}