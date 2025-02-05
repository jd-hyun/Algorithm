import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        LinkedList<String> queue = new LinkedList<>();

        for (int i = N - 1; i >= 0; i--) {
            if (A[i].equals("0")) {
                queue.add(B[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] C = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (String s : C) {
            queue.add(s);
            String pop = queue.pop();
            sb.append(pop).append(" ");
        }

        System.out.println(sb);
    }
}