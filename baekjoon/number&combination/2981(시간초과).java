import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long max = 0;
        long temp = 0;
        boolean isBreak = false;

        for (int i=0;i<N;i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i]>max)
                max = arr[i];
        }
        for (int i=2;i<=max;i++) {
            temp = arr[0]%i;
            for (int j=1;j<N;j++) {
                if (temp!=arr[j]%i) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak)
                System.out.print(i + " ");
            isBreak = false;
        }

    }
}