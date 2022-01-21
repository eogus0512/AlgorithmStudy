import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        int[] greedy = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0;i<N;i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        greedy[0] = time[0];
        for (int i=1;i<N;i++) {
            greedy[i] = greedy[i-1] + time[i];
        }
        for (int i=0;i<N;i++) {
            sum += greedy[i];
        }
        System.out.println(sum);
    }
}