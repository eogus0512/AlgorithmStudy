import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] str = br.readLine().split(" ");
        int max;

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        dp[0]=arr[0];
        max=arr[0];
        for (int i=1;i<N;i++) {
            max+=arr[i];
            if (max<arr[i]) {
                max=arr[i];
            }
            dp[i] = Math.max(dp[i-1], max);
        }
        System.out.println(dp[N-1]);
    }
}