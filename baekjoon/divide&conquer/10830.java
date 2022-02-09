import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static int[][] multiple(int[][] arr1, int[][] arr2, int N) {
        int[][] mul = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    mul[i][j] += arr1[i][k] * arr2[k][j];
                    mul[i][j] %= 1000;
                }
            }
        }
        return mul;
    }
    public static int[][] divide(int[][] arr, long exp, int N) {
        int[][] result;
        if (exp==1L) {
            return arr;
        }
        result = divide(arr, exp/2, N);
        result = multiple(result, result, N);
        if (exp%2==1L) {
            result = multiple(result, arr, N);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        long B = Long.parseLong(str[1]);
        int[][] arr = new int[N][N];
        int[][] result;

        for (int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            for (int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(str[j]) % 1000;
            }
        }
        result = divide(arr, B, N);
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
