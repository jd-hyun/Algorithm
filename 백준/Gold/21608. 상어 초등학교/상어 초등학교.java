import java.io.*;
import java.util.*;

class Position implements Comparable<Position> {
    private final int row;
    private final int col;
    private final int emptyCount;
    private final int likeCount;

    public Position(int row, int col, int emptyCount, int likeCount) {
        this.row = row;
        this.col = col;
        this.emptyCount = emptyCount;
        this.likeCount = likeCount;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public int compareTo(Position p) {
        // 1. likeCount 큰 순서로 정렬
        if (this.likeCount != p.likeCount) {
            return Integer.compare(p.likeCount, this.likeCount); // 내림차순
        }
        // 2. emptyCount 큰 순서로 정렬
        if (this.emptyCount != p.emptyCount) {
            return Integer.compare(p.emptyCount, this.emptyCount); // 내림차순
        }
        // 3. row 작은 순서로 정렬
        if (this.row != p.row) {
            return Integer.compare(this.row, p.row); // 오름차순
        }
        // 4. col 작은 순서로 정렬
        return Integer.compare(this.col, p.col); // 오름차순
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int N = Integer.parseInt(br.readLine());
        int[][] classroom = new int[N][N];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            String[] split = br.readLine().split(" ");
            int num = Integer.parseInt(split[0]);
            Set<Integer> set = new HashSet<>();

            for (int j = 1; j <= 4; j++) {
                set.add(Integer.parseInt(split[j]));
            }

            map.put(num, set);

            List<Position> positions = new ArrayList<>();

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (classroom[row][col] == 0) {
                        int emptyCount = 0;
                        int likeCount = 0;
                        for (int j = 0; j < 4; j++) {
                            int newRow = row + dx[j];
                            int newCol = col + dy[j];
                            if (newRow >= 0 && newRow < N && newCol >=0 && newCol < N) {
                                if (classroom[newRow][newCol] == 0) {
                                    emptyCount++;
                                } else if (set.contains(classroom[newRow][newCol])) {
                                    likeCount++;
                                }
                            }
                        }
                        positions.add(new Position(row, col, emptyCount, likeCount));
                    }
                }
            }

            Collections.sort(positions);
            Position position = positions.get(0);

            classroom[position.getRow()][position.getCol()] = num;
        }

        int[] satisfaction = {0, 1, 10, 100, 1000};
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int likeCount = 0;
                for (int k = 0; k < 4; k++) {
                    int newRow = i + dx[k];
                    int newCol = j + dy[k];

                    if (newRow >= 0 && newRow < N && newCol >=0 && newCol < N) {
                        if (map.get(classroom[i][j]).contains(classroom[newRow][newCol])) {
                            likeCount++;
                        }
                    }
                }
                result += satisfaction[likeCount];
            }
        }

        System.out.println(result);
    }
}