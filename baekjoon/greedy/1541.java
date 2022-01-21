import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        String[] token;
        int temp=0;
        int sum=0;

        for (int i=0;i<str.length;i++) {
            token = str[i].split("\\+");
            for (int j=0;j<token.length;j++) {
                temp += Integer.parseInt(token[j]);
            }
            if (i!=0) {
                sum -= temp;
            } else {
                sum += temp;
            }
            temp = 0;
        }
        System.out.println(sum);
    }
}