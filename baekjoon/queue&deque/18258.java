import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new LinkedList<>();
        String[] str;

        for (int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            switch (str[0]) {
                case "push" :
                    arr.offer(Integer.parseInt(str[1]));
                    break;
                case "pop" :
                    if (arr.size()==0)
                        sb.append(-1).append("\n");
                    else {
                        sb.append(arr.poll()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(arr.size()).append("\n");
                    break;
                case "empty" :
                    if (arr.size()==0)
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front" :
                    if (arr.size()==0)
                        sb.append(-1).append("\n");
                    else
                        sb.append(arr.peek()).append("\n");
                    break;
                case "back" :
                    if (arr.size()==0)
                        sb.append(-1).append("\n");
                    else
                        sb.append(arr.peekLast()).append("\n");
                    break;
                default:
                    sb.append("잘못된 명령문을 입력하였습니다.").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}