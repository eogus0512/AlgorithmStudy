import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[][] visited;
    static int[][] matrix;
    static int[] directX = {0, 0, 1, -1};
    static int[] directY = {1, -1, 0, 0};
    static int M, N, count=1, min;
    public static void dfs(int row, int column) {
        if (row>=N-1 && column>=M-1) {
            min = Math.min(min, count);
        } else {
            for (int i=0;i<4;i++) {
                int x = directX[i] + row;
                int y = directY[i] + column;
                if (x>=0 && y>=0 && x<N && y<M) {
                    if (matrix[x][y]!=0 && visited[x][y]==false) {
                        visited[row][column] = true;
                        count++;
                        dfs(x, y);
                        count--;
                        visited[row][column] = false;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        N = Integer.parseInt(str1[0]);
        M = Integer.parseInt(str1[1]);
        min = N*M;
        matrix = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i=0;i<N;i++) {
            String str2 = br.readLine();
            for (int j=0;j<M;j++) {
                matrix[i][j] = Character.getNumericValue(str2.charAt(j));
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }
}

