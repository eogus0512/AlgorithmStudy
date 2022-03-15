import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int result = 100001;
        int N = Integer.parseInt(str1[0]);
        long S = Long.parseLong(str1[1]);
        int[] arr = new int[N];
        String[] str2 = br.readLine().split(" ");
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(arr);
        int start = 0, end = 0;
        long sum = 0;
        while (true) {
            if (sum>=S) {
                sum -= arr[start];
                result = Math.min(result, (end-start));
                start++;
            } else if (end==N) {
                break;
            } else {
                sum += arr[end++];
            }
        }
        if (result == 100001) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}