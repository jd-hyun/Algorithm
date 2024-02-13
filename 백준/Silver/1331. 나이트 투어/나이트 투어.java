import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] chessboard = new boolean[6][6];
        boolean isValid = true;
        int startRow = 0;
        int startCol = 0;
        int preRow = 0;
        int preCol = 0;

        for (int i = 0; i < 36; i++) {
            String s = br.readLine();
            int col = s.charAt(0) - 65;
            int row = s.charAt(1) - '1';

            if (i == 0) {
                startRow = row;
                startCol = col;
            }

            else {
                if (Math.abs(row - preRow) >= 3) {
                    isValid = false;
                    continue;
                }
                if (Math.abs(col - preCol) >= 3) {
                    isValid = false;
                    continue;
                }
                if (Math.abs(row - preRow) + Math.abs(col - preCol) != 3) isValid = false;
            }

            if (chessboard[row][col]) {
                isValid = false;
            }
            else {
                chessboard[row][col] = true;
            }

            preRow = row;
            preCol = col;
        }

        if (Math.abs(startRow - preRow) + Math.abs(startCol - preCol) != 3) isValid = false;

        if (isValid) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
}