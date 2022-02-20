import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int sum(int[] arr, int s, int e) {
        if(s==0) return arr[e];
        else return arr[e]-arr[s-1];
    }
    public static int function(int[] arr) {
        int dp[][]=new int[arr.length][arr.length];
        int s[]=new int[arr.length];
        s[0]=arr[0];
        for(int i=1;i<arr.length;i++) {
            s[i]=s[i-1]+arr[i];
        }
        for(int i=0;i<arr.length-1;i++) {
            dp[i][i+1]=arr[i]+arr[i+1];
        }
        for(int gap=2;gap<arr.length;gap++) {
            for(int i=0;i+gap<arr.length;i++) {
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;

                for(int k=i;k<j;k++) {
                    dp[i][j]=Math.min(dp[i][k]+dp[k+1][j]+sum(s, i, j), dp[i][j]);
                }
            }
        }
        return dp[0][arr.length-1];
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int N=Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int arr[]=new int[N];
            for(int j=0;j<N;j++) {
                arr[j]=Integer.parseInt(str[j]);
            }
            sb.append(function(arr)).append("\n");
        }
        System.out.println(sb);
    }
}
