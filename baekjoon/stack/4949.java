import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[] stack;
    static int head = 0;
    public static void push(char c) {
        head++;
        stack[head] = c;
    }
    public static void pop() {
        stack[head] = 0;
        head--;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean err = false;
        String str = "";

        while(true) {
            str = br.readLine();
            if (str.equals("."))
                break;
            stack = new char[str.length()+1];
            for (int j=0;j<str.length();j++) {
                switch(str.charAt(j)) {
                    case '(' :
                        push(str.charAt(j));
                        break;
                    case '[' :
                        push(str.charAt(j));
                        break;
                    case ')' :
                        if (stack[head] == '(')
                            pop();
                        else
                            err = true;
                        break;
                    case ']' :
                        if (stack[head] == '[')
                            pop();
                        else
                            err = true;
                        break;
                    default :
                        continue;
                }
                if (head<0) {
                    err = true;
                    break;
                }
            }
            if (err || head != 0)
                System.out.println("no");
            else
                System.out.println("yes");
            head = 0;
            stack = null;
            err = false;
        }
    }
}