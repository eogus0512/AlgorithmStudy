import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N-1];
        long[] price = new long[N];
        String[] str;
        long min = 1000000000, sum=0;

        str = br.readLine().split(" ");
        for (int i=0;i<N-1;i++) {
            distance[i] = Long.parseLong(str[i]);
        }

        str = br.readLine().split(" ");
        for (int i=0;i<N;i++)
            price[i] = Long.parseLong(str[i]);

        for (int i=0;i<N-1;i++) {
            if (min>price[i]) {
                min = price[i];
            }
            sum += min*distance[i];
        }
        System.out.println(sum);
    }
}