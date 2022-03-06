import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class night {
    int y, x;
    night(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static Queue<night> q = new LinkedList<>();
    static int[][] matrix;
    static int N;
    static int[] directY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] directX = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void bfs() {
        while(!q.isEmpty()) {
            night t = q.poll();
            for (int i=0;i<8;i++) {
                int y = directY[i] + t.y;
                int x = directX[i] + t.x;
                if (y>=0 && x>=0 && y<N && x<N) {
                    if (matrix[y][x]==0) {
                        q.offer(new night(y, x));
                        matrix[y][x] = matrix[t.y][t.x] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            String[] str = br.readLine().split(" ");
            matrix[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            q.offer(new night(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
            bfs();
            str = br.readLine().split(" ");
            System.out.println(matrix[Integer.parseInt(str[0])][Integer.parseInt(str[1])]-1);
        }
    }
}

