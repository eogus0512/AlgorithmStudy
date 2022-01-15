import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static long MOD = 1000000000;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum=0;
        dp = new long [N+1][10];

        for(int i=1;i<=9;i++) { // dp배열 초기상태
            dp[1][i] = 1;
        }

        for(int i=2;i<=N;i++) { // 2인 경우부터 N까지 반복
            for(int j=0;j<10;j++) {
                if(j==0) dp[i][j] = (dp[i-1][j+1]) % MOD; // 끝자리가 0일 경우는 1일 때만 고려
                else if(j==9) dp[i][j] = dp[i-1][j-1] % MOD ; // 끝자리가 9일 경우는 8일 때만 고려
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% MOD; // 나머지는 -1, +1 모두 고려
            }
        }

        for(int i=0;i<10;i++) {
            sum += dp[N][i];

        }

        System.out.println(sum % MOD);
    }
}