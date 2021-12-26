import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static StringBuilder sb =  new StringBuilder();

    public static void star(int i, int j, int num) {
        if((i/num)%3 == 1 && (j/num)%3 == 1) {
            sb.append(" ");
        } else {
            if(num < 3)
                sb.append("*");
            else
                star(i, j, num/3);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i=0;i<num;i++) {
            for(int j=0;j<num;j++) {
                star(i, j, num);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
