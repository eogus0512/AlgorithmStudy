import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N+1];
        int max = 0;

        String[] str = br.readLine().split(" ");
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        for (int i=0;i<N;i++) {
            dp[i]=1;
            for (int j=0;j<i;j++) {
                if (arr[j]<arr[i] && dp[i]<dp[j]+1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int i=0;i<N;i++) {
            if (dp[i]>max) {
                max=dp[i];
            }
        }
        System.out.println(max);
    }
}