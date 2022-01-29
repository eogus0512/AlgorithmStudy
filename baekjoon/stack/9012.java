import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[] stack;
    static int N;
    static int head = -1;
    public static void push(char c) {
        head++;
        stack[head] = c;
    }
    public static int pop() {
        int result;
        if (head < 0) {
            result = -1;
            return result;
        } else {
            result = 0;
            stack[head] = 0;
            head--;
            return result;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        String str;
        int result = 0;

        for (int i=0;i<N;i++) {
            str = br.readLine();
            stack = new char[str.length()];
            for (int j=0;j<str.length();j++) {
                if (str.charAt(j) == '(') {
                    push('(');
                } else if (str.charAt(j) == ')') {
                    result = pop();
                    if (result == -1)
                        break;
                } else {
                    System.out.println("(,)이외의 다른 문자를 입력하였습니다.");
                }
            }
            if (head != -1 || result == -1)
                System.out.println("NO");
            else
                System.out.println("YES");
            head = -1;
            result = 0;
        }
    }
}