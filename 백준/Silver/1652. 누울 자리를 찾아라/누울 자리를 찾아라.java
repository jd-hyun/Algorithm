import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            int emptySquare = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') emptySquare += 1;
                else {
                    if (emptySquare >= 2) rowCount += 1;
                    emptySquare = 0;
                }
            }
            if (emptySquare >= 2) rowCount += 1;
        }

        for (int j = 0; j < N; j++) {
            int emptySquare = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') emptySquare += 1;
                else {
                    if (emptySquare >= 2) colCount += 1;
                    emptySquare = 0;
                }
            }
            if (emptySquare >= 2) colCount += 1;
        }

        System.out.println(rowCount + " " + colCount);
    }
}