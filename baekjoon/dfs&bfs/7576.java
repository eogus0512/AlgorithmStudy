import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class tomato {
    int x, y;
    tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static StringBuilder sb = new StringBuilder();
    static Queue<tomato> q = new LinkedList<>();
    static int[][] matrix;
    static int N, M;
    static int[] directX = {0, 0, 1, -1};
    static int[] directY = {1, -1, 0, 0};
    public static int bfs() {
        int result = 0;
        while(!q.isEmpty()) {
            tomato t = q.poll();
            for (int i=0;i<4;i++) {
                int x = directX[i] + t.x;
                int y = directY[i] + t.y;
                if (x>=0 && y>=0 && x<N && y<M) {
                    if (matrix[x][y]==0) {
                        q.offer(new tomato(x, y));
                        matrix[x][y] = matrix[t.x][t.y] + 1;
                    }
                }
            }
        }

        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (matrix[i][j] == 0) {
                    return -1;
                } else {
                    result = Math.max(result, matrix[i][j]);
                }
            }
        }
        return result-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);

        matrix = new int[N][M];
        for (int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            for (int j=0;j<M;j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
                if (matrix[i][j] == 1) {
                    q.offer(new tomato(i, j));
                }
            }
        }
        System.out.println(bfs());
    }
}

