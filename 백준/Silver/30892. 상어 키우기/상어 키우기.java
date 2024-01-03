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

        for (int shark : sharks) {
            stack.push(shark);
        }


        int count = 0;
        while (count < K) {
            boolean ate = false;

            for (int i = stack.size() - 1; i >= 0; i--) {
                if (T > stack.get(i)) {
                    ate = true;
                    T += stack.get(i);
                    stack.removeElementAt(i);
                    count++;
                    break;
                }
            }

            if (!ate) break;
        }
    }
}