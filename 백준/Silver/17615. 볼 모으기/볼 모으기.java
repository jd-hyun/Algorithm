import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int lastRed = 0;
        int lastBlue = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == 'R') lastRed++;
                }
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == 'R') {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == 'B') lastBlue++;
                }
                break;
            }
        }
        System.out.println(Math.min(lastRed, lastBlue));
    }
}