import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class tomato {
    int x, y, z;
    tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static StringBuilder sb = new StringBuilder();
    static Queue<tomato> q = new LinkedList<>();
    static int[][][] matrix;
    static int N, M, H;
    static int[] directX = {1, -1, 0, 0, 0, 0};
    static int[] directY = {0, 0, 1, -1, 0, 0};
    static int[] directZ = {0, 0, 0, 0, 1, -1};
    public static int bfs() {
        int result = 0;
        while(!q.isEmpty()) {
            tomato t = q.poll();
            for (int i=0;i<6;i++) {
                int x = directX[i] + t.x;
                int y = directY[i] + t.y;
                int z = directZ[i] + t.z;
                if (x>=0 && y>=0 && z>=0 && x<H && y<N && z<M ) {
                    if (matrix[x][y][z]==0) {
                        q.offer(new tomato(x, y, z));
                        matrix[x][y][z] = matrix[t.x][t.y][t.z] + 1;
                    }
                }
            }
        }

        for (int i=0;i<H;i++) {
            for (int j=0;j<N;j++) {
                for (int k=0;k<M;k++) {
                    if (matrix[i][j][k] == 0) {
                        return -1;
                    } else {
                        result = Math.max(result, matrix[i][j][k]);
                    }
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
        H = Integer.parseInt(str[2]);

        matrix = new int[H][N][M];
        for (int i=0;i<H;i++) {
            for (int j=0;j<N;j++) {
                str = br.readLine().split(" ");
                for (int k=0;k<M;k++) {
                    matrix[i][j][k] = Integer.parseInt(str[k]);
                    if (matrix[i][j][k] == 1) {
                        q.offer(new tomato(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
}

