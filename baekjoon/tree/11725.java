import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static boolean[] visited;

    public static void dfs(int a) {
        if (visited[a]) {
            return;
        }
        visited[a] = true;

        for (int i:arr[a]) {
            if (!visited[i]) {
                parent[i] = a;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for (int i=1;i<=N;i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i=1;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        for (int i=1;i<=N;i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        for (int i=2;i<=N;i++) {
            System.out.println(parent[i]);
        }
    }
}