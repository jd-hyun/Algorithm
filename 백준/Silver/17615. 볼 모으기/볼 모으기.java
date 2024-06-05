import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringTokenizer st1 = new StringTokenizer(s, "B");
        StringTokenizer st2 = new StringTokenizer(s, "R");
        int redCount = 0;
        int blueCount = 0;
        int countRedTokens = st1.countTokens();
        int countBlueTokens = st2.countTokens();

        if ((countRedTokens == 1 && countBlueTokens == 1) || (countRedTokens == 0 && countBlueTokens == 1) || (countRedTokens == 1 && countBlueTokens == 0)) {
            System.out.println(0);
            return;
        }

        int[] redBalls = new int[countRedTokens];
        int[] blueBalls = new int[countBlueTokens];

        for (int i = 0; i < countRedTokens; i++) {
            redBalls[i] = st1.nextToken().length();
            redCount += redBalls[i];
        }

        if (s.charAt(0) == 'R' && s.charAt(N - 1) == 'R') {
            redCount -= Math.max(redBalls[0], redBalls[countRedTokens - 1]);
        } else if (s.charAt(0) == 'B' && s.charAt(N - 1) == 'R') {
            redCount -= redBalls[countRedTokens - 1];
        } else if (s.charAt(0) == 'R' && s.charAt(N - 1) == 'B') {
            redCount -= redBalls[0];
        }

        for (int i = 0; i < countBlueTokens; i++) {
            blueBalls[i] = st2.nextToken().length();
            blueCount += blueBalls[i];
        }

        if (s.charAt(0) == 'B' && s.charAt(N - 1) == 'B') {
            blueCount -= Math.max(blueBalls[0], blueBalls[countBlueTokens - 1]);
        } else if (s.charAt(0) == 'R' && s.charAt(N - 1) == 'B') {
            blueCount -= blueBalls[countBlueTokens - 1];
        } else if (s.charAt(0) == 'B' && s.charAt(N - 1) == 'R') {
            blueCount -= blueBalls[0];
        }

        System.out.println(Math.min(redCount, blueCount));
    }
}