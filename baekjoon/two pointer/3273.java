import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int start = 0, end = n-1;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) count++;

            if (sum < x) start++;
            else end--;
        }
        System.out.println(count);
    }
}