import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int length = S.length();
        int zeroNum = 0;

        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '0') zeroNum++;
        }

        int oneNum = (length - zeroNum) / 2;
        zeroNum /= 2;
        int i = 0;

        while (true) {
            if (oneNum == 0) break;

            if (S.charAt(i) == '1') {
                S = S.substring(0, i) + S.substring(i + 1);
                oneNum--;
            } else {
                i++;
            }
        }

        i = S.length() - 1;
        while (true) {
            if (zeroNum == 0) break;

            if (S.charAt(i) == '0') {
                if (i == S.length() - 1) {
                    S = S.substring(0, i);
                } else {
                    S = S.substring(0, i) + S.substring(i + 1);
                }
                zeroNum--;
                i = S.length() - 1;
            } else {
                i--;
            }
        }

        System.out.println(S);
    }
}