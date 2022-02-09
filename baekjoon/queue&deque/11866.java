import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        Queue<Integer> arr = new LinkedList<>();
        Integer temp;

        for (int i=1;i<=N;i++) {
            arr.add(i);
        }
        sb.append("<");
        while(!arr.isEmpty()) {
            for (int i=0;i<K-1;i++) {
                temp = arr.poll();
                arr.offer(temp);
            }
            sb.append(arr.poll()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()).append(">");
        System.out.println(sb);
    }
}