import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         arr = new int[N];

         nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (check(depth)) {
                nQueen(depth + 1);
            };
        }
    }

    private static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            } else if (Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }
        return true;
    }
}