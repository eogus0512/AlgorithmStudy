import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int N, int M, int depth, int[] arr, boolean[] visit) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 0; i < N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1, arr, visit);
                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        boolean[] visit = new boolean[N];
        int[] arr = new int[M];

        dfs(N, M, 0, arr, visit);
        System.out.println(sb);
    }
}
