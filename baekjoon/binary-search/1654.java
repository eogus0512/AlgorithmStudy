import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static long binary(long[] arr, int num) {
        long count;
        long start = 0;
        long end = arr[arr.length-1]+1;
        long mid;

        while(start<end) {
            mid = (start+end)/2;
            count = 0;
            for (int i=0;i<arr.length;i++) {
                count+=(arr[i]/mid);
            }
            if (count<num) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int K = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        long[] arr = new long[K];
        for (int i=0;i<K;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binary(arr, N)-1);
    }
}
