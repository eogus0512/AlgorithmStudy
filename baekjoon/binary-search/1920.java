import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int binary(int[] arr, int num, int start, int end) {
        int mid = (start+end)/2;
        while(start<=end) {
            if (num==arr[mid]) {
                return 1;
            } else if (num<arr[mid]) {
                return binary(arr, num, start, mid-1);
            } else {
                return binary(arr, num, mid+1, end);
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] str = br.readLine().split(" ");

        for (int i=0;i<N;i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        for (int i=0;i<M;i++) {
            System.out.println(binary(A, Integer.parseInt(str[i]), 0, N-1));
        }

    }
}
