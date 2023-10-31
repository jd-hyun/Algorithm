import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int chocolate = 1;

        while (K > chocolate) {
            chocolate *= 2;
        }

        System.out.print(chocolate + " ");

        int count = 0;

        while (K % chocolate != 0) {
            chocolate /= 2;
            count++;
        }

        System.out.println(count);
    }
}