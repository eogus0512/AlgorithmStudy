import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static long[] arr;
    public static long max(long distance) {
        long count = 1;
        long temp = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (temp+distance <= arr[i]) {
                count++;
                temp = arr[i];
            }
        }
        return count;
    }
    public static long binary(long C) {
        long start = 1;
        long end = arr[arr.length-1]-arr[0]+1;
        long mid;

        while(start<end) {
            mid = (start+end)/2;
            if (max(mid)<C) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        long C = Long.parseLong(str[1]);
        arr = new long[N];
        for (int i=0;i<N;i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binary(C));
    }
}
