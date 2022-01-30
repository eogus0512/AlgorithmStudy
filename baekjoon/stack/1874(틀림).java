import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] stack;
    static int N;
    static int head = 0;
    static StringBuilder sb = new StringBuilder();
    public static void push(int num) {
        head++;
        stack[head] = num;
        sb.append('+').append("\n");
    }
    public static void pop() {
        stack[head] = 0;
        head--;
        sb.append('-').append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        stack = new int[N+1];

        for (int i=1;i<=N;i++)
            arr[i] = Integer.parseInt(br.readLine());

        push(1);
        int i = 0;
        int a = 2;

        while(i<=N) {
            if(head < 0 || head > N) {
                System.out.println("NO");
                break;
            } else if (arr[i] != stack[head]) {
                push(a);
                a++;
            } else {
                pop();
                i++;
            }
        }
        if(i==N) {
            System.out.println(sb);
        }
    }
}