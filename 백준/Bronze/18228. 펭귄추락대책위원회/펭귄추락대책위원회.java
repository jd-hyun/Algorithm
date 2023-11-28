import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ices = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int penguin = 0;

        for (int i = 1; i <= N; i++) {
            ices[i] = Integer.parseInt(st.nextToken());
            if (ices[i] == -1) penguin = i;
        }

        int leftMin = 1000000001;
        for (int i = 1; i < penguin; i++) {
            if (ices[i] < leftMin) {
                leftMin = ices[i];
            }
        }

        int rightMin = 1000000001;
        for (int i = penguin + 1; i <= N; i++) {
            if (ices[i] < rightMin) {
                rightMin = ices[i];
            }
        }

        System.out.println(leftMin + rightMin);
    }
}