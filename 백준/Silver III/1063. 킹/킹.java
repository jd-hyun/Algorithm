import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        int kingCol = king.charAt(0);
        int kingRow = king.charAt(1);
        int stoneCol = stone.charAt(0);
        int stoneRow = stone.charAt(1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            switch (s) {
                case "R":
                    if (kingCol != 72) {
                        if ((kingCol + 1 == stoneCol) && (kingRow == stoneRow)) {
                            if (stoneCol != 72) {
                                stoneCol += 1;
                                kingCol += 1;
                            }
                        } else {
                            kingCol += 1;
                        }
                    }
                    break;
                case "L":
                    if (kingCol != 65) {
                        if ((kingCol - 1 == stoneCol) && (kingRow == stoneRow)) {
                            if (stoneCol != 65) {
                                stoneCol -= 1;
                                kingCol -= 1;
                            }
                        } else {
                            kingCol -= 1;
                        }
                    }
                    break;
                case "B":
                    if (kingRow != 49) {
                        if ((kingRow - 1 == stoneRow) && (kingCol == stoneCol)) {
                            if (stoneRow != 49) {
                                stoneRow -= 1;
                                kingRow -= 1;
                            }
                        } else {
                            kingRow -= 1;
                        }
                    }
                    break;
                case "T":
                    if (kingRow != 56) {
                        if ((kingRow + 1 == stoneRow) && (kingCol == stoneCol)) {
                            if (stoneRow != 56) {
                                stoneRow += 1;
                                kingRow += 1;
                            }
                        } else {
                            kingRow += 1;
                        }
                    }
                    break;
                case "RT":
                    if (kingCol != 72 && kingRow != 56) {
                        if ((kingRow + 1 == stoneRow) && (kingCol + 1 == stoneCol)) {
                            if (stoneCol != 72 && stoneRow != 56) {
                                stoneCol += 1;
                                stoneRow += 1;
                                kingCol += 1;
                                kingRow += 1;
                            }
                        } else {
                            kingCol += 1;
                            kingRow += 1;
                        }
                    }
                    break;
                case "LT":
                    if (kingCol != 65 && kingRow != 56) {
                        if ((kingRow + 1 == stoneRow) && (kingCol - 1 == stoneCol)) {
                            if (stoneCol != 65 && stoneRow != 56) {
                                stoneCol -= 1;
                                stoneRow += 1;
                                kingCol -= 1;
                                kingRow += 1;
                            }
                        } else {
                            kingCol -= 1;
                            kingRow += 1;
                        }
                    }
                    break;
                case "RB":
                    if (kingCol != 72 && kingRow != 49) {
                        if ((kingRow - 1 == stoneRow) && (kingCol + 1 == stoneCol)) {
                            if (stoneCol != 72 && stoneRow != 49) {
                                stoneCol += 1;
                                stoneRow -= 1;
                                kingCol += 1;
                                kingRow -= 1;
                            }
                        } else {
                            kingCol += 1;
                            kingRow -= 1;
                        }
                    }
                    break;
                case "LB":
                    if (kingCol != 65 && kingRow != 49) {
                        if ((kingRow - 1 == stoneRow) && (kingCol - 1 == stoneCol)) {
                            if (stoneCol != 65 && stoneRow != 49) {
                                stoneCol -= 1;
                                stoneRow -= 1;
                                kingCol -= 1;
                                kingRow -= 1;
                            }
                        } else {
                            kingCol -= 1;
                            kingRow -= 1;
                        }
                    }
                    break;
            }
        }
        sb.append((char) kingCol).append((char) kingRow).append("\n").append((char) stoneCol).append((char) stoneRow);
        System.out.println(sb);
    }
}