import java.io.*;
import java.util.*;
import java.lang.*;

class Pillar {
    private int position;

    private int height;

    public Pillar(int position, int height) {
        this.position = position;
        this.height = height;
    }

    public int getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Pillar[] pillars = new Pillar[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            pillars[i] = new Pillar(position, height);
        }

        Arrays.sort(pillars, new Comparator<Pillar>() {
            @Override
            public int compare(Pillar o1, Pillar o2) {
                return Integer.compare(o1.getPosition(), o2.getPosition());
            }
        });

        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < N; i++) {
            if (pillars[i].getHeight() >= max) {
                max = pillars[i].getHeight();
                maxIndex = i;
            }
        }
        int area = 0;
        int position = pillars[0].getPosition();
        int height = pillars[0].getHeight();

        for (int i = 1; i <= maxIndex; i++) {
            int temp = pillars[i].getHeight();

            if (temp >= height) {
                area += (pillars[i].getPosition() - position) * height;
                height = temp;
                position = pillars[i].getPosition();
            }
        }

        area += pillars[maxIndex].getHeight();

        position = pillars[N - 1].getPosition();
        height = pillars[N - 1].getHeight();

        for (int i = N - 2; i >= maxIndex; i--) {
            int temp = pillars[i].getHeight();

            if (temp > height) {
                area += (position - pillars[i].getPosition()) * height;
                height = temp;
                position = pillars[i].getPosition();
            }
        }

        System.out.println(area);
    }
}