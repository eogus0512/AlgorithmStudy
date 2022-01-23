import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static int bc(int n, int k) {
        if (dp[n][k]>0) {
            return dp[n][k];
        } else if (n==k || k==0) {
            dp[n][k]=1;
            return dp[n][k];
        } else {
            dp[n][k] = (bc(n-1, k-1) + bc(n-1, k))%10007;
            return dp[n][k];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        System.out.println(bc(N, K));
    }
}