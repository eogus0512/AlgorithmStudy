import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);

            if (a == b) return o1>o2 ? 1:-1;
            return a-b;
        });
        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            Integer temp;
            if (num!=0) {
                pq.offer(num);
            } else {
                temp = pq.poll();
                if (temp != null) {
                    sb.append(temp).append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
