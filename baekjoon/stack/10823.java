import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[] stack;
    static int N;
    static int head = -1;
    public static void push(int num) {
        if (head < N) {
            head++;
            stack[head] = num;
        } else {
            System.out.println("스택에 공간이 부족합니다.");
        }
    }
    public static int pop() {
        int result;
        if (head >= 0) {
            result = stack[head];
            stack[head] = 0;
            head--;
        } else {
            result = -1;
        }
        return result;
    }
    public static int size() {
        return head+1;
    }
    public static int empty() {
        if (head >= 0)
            return 0;
        else
            return 1;
    }
    public static int top() {
        if (head >=0)
            return stack[head];
        else
            return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        stack = new int[N];
        String[] str;

        for (int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            switch (str[0]) {
                case "push" :
                    push(Integer.parseInt(str[1]));
                    break;
                case "pop" :
                    System.out.println(pop());
                    break;
                case "size" :
                    System.out.println(size());
                    break;
                case "empty" :
                    System.out.println(empty());
                    break;
                case "top" :
                    System.out.println(top());
                    break;
                default:
                    System.out.println("잘못된 명령문을 입력하였습니다.");
                    break;
            }
        }
    }
}