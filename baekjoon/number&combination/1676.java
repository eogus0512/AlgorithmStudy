import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp;
        int[][] arr = new int[N+1][2];
        for (int i=1;i<=N;i++) {
            temp = i;
            arr[i][0] += arr[i-1][0];
            arr[i][1] += arr[i-1][1];
            while (temp%2==0) {
                temp /= 2;
                arr[i][0]++;
            }
            while (temp%5==0) {
                temp /= 5;
                arr[i][1]++;
            }
        }
        System.out.println(arr[N][0]<arr[N][1]?arr[N][0]:arr[N][1]);
    }
}