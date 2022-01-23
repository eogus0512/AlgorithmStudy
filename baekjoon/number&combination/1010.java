import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] dp;

    public static int bc(int n, int k) {
        if (dp[n][k]>0) {
            return dp[n][k];
        } else if (n==k || k==0) {
            dp[n][k]=1;
            return dp[n][k];
        } else {
            dp[n][k] = (bc(n-1, k-1) + bc(n-1, k));
            return dp[n][k];
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str;
        int N, M;

        for (int i=0;i<T;i++) {
            str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            dp = new int[M+1][N+1];
            sb.append(bc(M, N) + "\n");
        }
        System.out.println(sb);
    }
}