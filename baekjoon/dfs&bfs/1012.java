import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
    static int[][] matrix;
    static int[] directX = {0, 0, 1, -1};
    static int[] directY = {1, -1, 0, 0};
    static int M, N, K;
    public static void dfs(int row, int column) {
        visited[row][column] = true;

        for (int i=0;i<4;i++) {
            int x = directX[i] + row;
            int y = directY[i] + column;
            if (x>=0 && y>=0 && x<N && y<M) {
                if (matrix[x][y]==1 && visited[x][y]==false)
                    dfs(x, y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int a=0;a<T;a++) {
            String[] str = br.readLine().split(" ");
            int count=0;
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);
            matrix = new int[N][M];
            visited = new boolean[N][M];
            for (int i=0;i<N;i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i=0;i<K;i++) {
                str = br.readLine().split(" ");
                matrix[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
            }
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    if (matrix[i][j] == 1 && visited[i][j] == false) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

