import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static boolean pelin(int[] arr, int S, int E) {
        while (S <= E) {
            if (arr[S] != arr[E]) {
                return false;
            }
            S++; E--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N+1];
        for (int i=1;i<=N;i++) {
                arr[i] = Integer.parseInt(str[i-1]);
        }
        int M = Integer.parseInt(br.readLine());

        for (int i=0;i<M;i++) {
            str = br.readLine().split(" ");
            int S = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            if (pelin(arr, S, E)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
