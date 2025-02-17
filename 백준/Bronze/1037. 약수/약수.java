import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = 1;

        for (String s : split) {
            int num = Integer.parseInt(s);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(min * max);
    }
}