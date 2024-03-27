import java.io.*;
import java.util.*;

class Team {
    private int[] points;

    private int number;
    private int time;

    public void setPoints(int[] points) {
        this.points = points;
    }

    public int[] getPoints() {
        return points;
    }

    public int getNumber() {
        return number;
    }

    public int getTime() {
        return time;
    }



    public void setNumber(int number) {
        this.number = number;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTotalPoints() {
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return sum;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n + 1];

            for (int j = 1; j <= n; j++) {
                teams[j] = new Team();
                teams[j].setPoints(new int[k]);
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken()) - 1;
                int point = Integer.parseInt(st.nextToken());

                teams[id].getPoints()[problemNum] = Math.max(teams[id].getPoints()[problemNum], point);
                teams[id].setNumber(teams[id].getNumber() + 1);
                teams[id].setTime(j);
            }

            int rank = 1;
            for (int j = 1; j <= n; j++) {
                if (j == t) continue;

                if (teams[j].getTotalPoints() > teams[t].getTotalPoints()) rank++;
                if (teams[j].getTotalPoints() == teams[t].getTotalPoints()) {
                    if (teams[j].getNumber() < teams[t].getNumber()) rank++;
                    else if (teams[j].getNumber() == teams[t].getNumber()) {
                        if (teams[j].getTime() < teams[t].getTime()) rank++;
                    }
                }
            }
            sb.append(rank).append("\n");
        }
        System.out.println(sb);
    }
}