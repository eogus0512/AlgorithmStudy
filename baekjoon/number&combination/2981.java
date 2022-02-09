import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int GCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int temp;

        while(min!=0) {
            temp = max%min;
            max = min;
            min = temp;
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] diff = new int[N-1];
        int result = 0;

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i=0;i<N-1;i++) {
            diff[i] = arr[i+1] - arr[i];
        }

        if (N<=2) {
            result = diff[0];
        } else {
            int[] gcd = new int[N-2];
            gcd[0] = GCD(diff[0], diff[1]);
            for (int i=1;i<N-2;i++) {
                gcd[i] = GCD(diff[i], gcd[i-1]);
            }
            result = gcd[N-3];
        }

        for (int i=2;i<=result;i++) {
            if (result%i==0)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}