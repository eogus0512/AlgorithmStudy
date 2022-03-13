import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] list;
    static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            int v = n.vertex;
            int w = n.weight;
            if (distance[v] >= w) {
                for (int i=0;i<list[v].size();i++) {
                    int new_v = list[v].get(i).vertex;
                    int new_w = list[v].get(i).weight + w;

                    if (new_w < distance[new_v]) {
                        distance[new_v] = new_w;
                        q.add(new Node(new_v, new_w));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        int K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for (int i=1;i<=V;i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[V+1];
        Arrays.fill(distance, INF);
        distance[K] = 0;
        for (int i=0;i<E;i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i=1;i<=V;i++) {
            if (distance[i]==INF) {
                sb.append("INF" + "\n");
            } else sb.append(distance[i] + "\n");
        }
        System.out.println(sb);
    }
}

