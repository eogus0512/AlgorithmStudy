import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static StringBuilder sb =  new StringBuilder();

    public static void hanoi(int num, int from, int by, int to) {
        if (num==1) {
            sb.append(from + " " + to + "\n");
        } else {
            hanoi(num-1, from, to, by);
            sb.append(from + " " + to + "\n");
            hanoi(num-1, by, from , to);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, num) - 1).append("\n");
        hanoi(num, 1, 2, 3);
        System.out.println(sb);
    }
}
