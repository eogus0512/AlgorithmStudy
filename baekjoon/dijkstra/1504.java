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
        int[] must = new int[4];
        int sum1 = 0, sum2 = 0;
        int N = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        list = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[N+1];
        for (int i=0;i<E;i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        must[0] = 1; must[3] = N;
        str = br.readLine().split(" ");
        must[1] = Integer.parseInt(str[0]);
        must[2] = Integer.parseInt(str[1]);
        for (int i=0;i<3;i++) {
            Arrays.fill(distance, INF);
            distance[must[i]] = 0;
            dijkstra(must[i]);
            if (distance[must[i+1]]==INF) {
                sum1 = -1;
                break;
            } else sum1 += distance[must[i+1]];
        }

        must[1] = Integer.parseInt(str[1]);
        must[2] = Integer.parseInt(str[0]);
        for (int i=0;i<3;i++) {
            Arrays.fill(distance, INF);
            distance[must[i]] = 0;
            dijkstra(must[i]);
            if (distance[must[i+1]]==INF) {
                sum2 = -1;
                break;
            } else sum2 += distance[must[i+1]];
        }

        if (sum1==-1 || sum2==-1) {
            System.out.println(sum1>=sum2?sum1:sum2);
        } else System.out.println(sum1<=sum2?sum1:sum2);
    }
}

