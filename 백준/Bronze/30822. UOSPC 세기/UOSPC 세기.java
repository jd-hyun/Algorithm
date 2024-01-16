import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int u = 0;
        int o = 0;
        int s = 0;
        int p = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            switch (S.charAt(i)) {
                case 'u':
                    u++;
                    break;
                case 'o':
                    o++;
                    break;
                case 's':
                    s++;
                    break;
                case 'p':
                    p++;
                    break;
                case 'c':
                    c++;
                    break;
            }
        }
        System.out.println(Math.min(Math.min(Math.min(u, o), Math.min(s, p)), c));
    }
}