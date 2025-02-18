import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        boolean[] arr = new boolean[N + 1];

        int i = 2;
        int count = 0;

        while (true) {
            if (arr[i]) {
                i++;
                continue;
            }

            int j = 1;
            while (i * j <= N) {
                if (!arr[i * j]) {
                    arr[i * j] = true;
                    count++;
                    if (count == K) {
                        System.out.println(i * j);
                        return;
                    }
                }
                j++;
            }
            i++;
        }
    }
}