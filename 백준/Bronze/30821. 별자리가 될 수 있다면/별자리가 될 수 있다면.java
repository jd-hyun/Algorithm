import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long count = 1;
        for (int i = N; i > (N - 5); i--) {
            count *= i;
        }

        for (int i = 5; i > 0; i--) {
            count /= i;
        }

        System.out.println(count);
    }
}