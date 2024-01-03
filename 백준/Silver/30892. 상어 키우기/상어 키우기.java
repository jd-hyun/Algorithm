import java.io.*;
import java.util.*;

public class Main {
    static int[] sharks;
    static int N, K;

    static long T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        sharks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sharks);

        calculateMaxSize();

        System.out.println(T);
    }

    static void calculateMaxSize() {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        int count = 0;
        while (count < K) {

            while (index < N && sharks[index] < T) {
                stack.push(sharks[index++]);
            }

            if (stack.isEmpty()) break;

            T += stack.pop();
            count++;
        }
    }
}