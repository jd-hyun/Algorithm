import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();

        if ((N - K) % 2 == 0) {
            sb.append(S.substring(K - 1)).append(new StringBuilder(S.substring(0, K - 1)).reverse()).append("\n");
        }
        else {
            sb.append(S.substring(K - 1)).append(S.substring(0, K - 1)).append("\n");
        }

        System.out.println(sb);
    }
}