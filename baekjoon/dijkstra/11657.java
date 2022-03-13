import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Node{
    int u;
    int v;
    int time;

    public Node(int u, int v, int time) {
        this.u = u;
        this.v = v;
        this.time = time;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node> list = new ArrayList<>();
    static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static boolean bellmanford(int start, int N, int M) {
        distance[start] = 0;
        for (int i=1;i<=N;i++) {
            for (int j=0;j<M;j++) {
                int u = list.get(j).u;
                int v = list.get(j).v;
                int time = list.get(j).time;

                if (distance[u]<INF) {
                    if (distance[v]>(distance[u]+time)) {
                        distance[v] = distance[u] + time;

                        if (i==N) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        distance = new int[N+1];
        Arrays.fill(distance, INF);

        for (int i=0;i<M;i++) {
            str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            int C = Integer.parseInt(str[2]);
            list.add(new Node(A, B, C));
        }

        if(!bellmanford(1, N, M)) {
            sb.append(-1 + "\n");
        } else {
            for (int i=2;i<=N;i++) {
                if (distance[i]==INF) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(distance[i] + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}

