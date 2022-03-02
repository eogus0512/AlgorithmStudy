import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] matrix;
    static int N, M, V;
    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for (int i=1;i<=N;i++) {
            if (matrix[v][i]==1 && visited[i]==false)
                dfs(i);
        }
    }
    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + " ");

            for (int i=1;i<=N;i++) {
                if (matrix[temp][i]==1 && visited[i]==false) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        V = Integer.parseInt(str[2]);

        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        matrix = new int[N+1][N+1];
        for (int i=1;i<=M;i++) {
            str = br.readLine().split(" ");
            matrix[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            matrix[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }
        dfs(V);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
}

