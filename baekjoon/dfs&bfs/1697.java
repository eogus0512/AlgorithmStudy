import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] matrix;
    static int N, K;
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int next;
        matrix[N] = 1;
        q.offer(N);

        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i=0;i<3;i++) {
                if (i==0) {
                    next = temp - 1;
                } else if (i==1) {
                    next = temp + 1;
                } else {
                    next = temp * 2;
                }
                if (next >= 0 && next < matrix.length && matrix[next] == 0) {
                    q.offer(next);
                    matrix[next] = matrix[temp] + 1;
                    if (next == K) {
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        matrix = new int[100001];
        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(matrix[K]-1);
        }
    }
}

