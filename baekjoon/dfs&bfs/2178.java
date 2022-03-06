import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class maze {
    int x, y;
    maze(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] matrix;
    static int[] directX = {0, 0, 1, -1};
    static int[] directY = {1, -1, 0, 0};
    static int M, N;
    public static void bfs() {
        Queue<maze> q = new LinkedList<>();
        q.offer(new maze(0, 0));

        while (!q.isEmpty()) {
            maze temp = q.poll();
            for (int i=0;i<4;i++) {
                int x = directX[i] + temp.x;
                int y = directY[i] + temp.y;
                if (x>=0 && y>=0 && x<N && y<M) {
                    if (matrix[x][y]==1) {
                        q.offer(new maze(x, y));
                        matrix[x][y] = matrix[temp.x][temp.y] + 1;
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
        matrix = new int[N][M];

        for (int i=0;i<N;i++) {
            String str2 = br.readLine();
            for (int j=0;j<M;j++) {
                matrix[i][j] = Character.getNumericValue(str2.charAt(j));
            }
        }
        bfs();
        System.out.println(matrix[N-1][M-1]);
    }
}

