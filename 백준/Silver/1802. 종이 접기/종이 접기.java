import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            if (isFold(s, 0, s.length() - 1)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    static boolean isFold(String s, int start, int end) {
        if (start == end) return true;

        int mid = (start + end) / 2;

        for (int i = start; i < mid; i++) {
            if (s.charAt(i) == s.charAt(end - i)) return false;
        }

         return isFold(s, start, mid - 1) && isFold(s, mid + 1, end);
    }
}