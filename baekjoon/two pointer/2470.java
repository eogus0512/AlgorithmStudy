import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long min = Integer.MAX_VALUE;
        String[] str = br.readLine().split(" ");
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int start = 0, end = n-1;
        long first = 0, second = 0;
        while (start < end) {
            long sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                first = arr[start];
                second = arr[end];
            }
            if (sum > 0) end --;
            else start ++;
        }
        System.out.print(first + " " + second);
    }
}