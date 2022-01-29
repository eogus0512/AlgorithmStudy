import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[] stack;
    static int N;
    static int head = -1;
    static int sum;
    public static void push(int num) {
        head++;
        stack[head] = num;
        sum += num;
    }
    public static void pop() {
        sum -= stack[head];
        stack[head] = 0;
        head--;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        stack = new int[N];
        int a;

        for (int i=0;i<N;i++) {
            a = Integer.parseInt(br.readLine());
            switch(a) {
                case 0 : pop();
                break;
                default : push(a);
                break;
            }
        }
        System.out.println(sum);
    }
}