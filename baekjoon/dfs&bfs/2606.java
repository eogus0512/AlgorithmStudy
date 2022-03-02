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
    static int N, M, count=0;
    public static void dfs(int v) {
        visited[v] = true;
        count++;

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
            count++;

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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        matrix = new int[N+1][N+1];
        for (int i=1;i<=M;i++) {
            String[] str = br.readLine().split(" ");
            matrix[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            matrix[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }
        dfs(1);
        System.out.println(count-1);
    }
}

