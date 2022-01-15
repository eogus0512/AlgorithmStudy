import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str;
        int[][] num = new int[N][N];

        for (int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            for (int j=0;j<str.length;j++) {
                num[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                num[i-1][j] += Math.max(num[i][j], num[i][j + 1]);
        }

        System.out.println(num[0][0]);
    }
}