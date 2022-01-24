import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int temp, two, five;
        int[][] arr = new int[n+1][2];

        for (int i=1;i<=n;i++) {
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
        two = arr[n][0]-arr[m][0]-arr[n-m][0];
        five = arr[n][1]-arr[m][1]-arr[n-m][1];
        System.out.println(two<five?two:five);
    }
}