import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N, K;
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        int[][] arr = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];

        for (int i=1;i<=N;i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=K;j++) {
                if (arr[i][0]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]]+arr[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}