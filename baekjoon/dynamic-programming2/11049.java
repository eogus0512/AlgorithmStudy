import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[][] dp = new int[N][N];
        String[] str;

        for(int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            arr[i] = Integer.parseInt(str[0]);
            arr[i+1] = Integer.parseInt(str[1]);
        }

        for(int i=2;i<N+1;i++) {
            for(int j=0;j<N-i+1;j++) {
                dp[j][j+i-1] = INF;
                for(int k=j;k<j+i-1;k++) {
                    int value = dp[j][k] + dp[k+1][j+i-1] + (arr[j]*arr[k+1]*arr[j+i]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
