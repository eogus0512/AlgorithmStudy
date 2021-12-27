import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int end(int cnt) {
        int result=0;
        String num;
        int temp = 0;
        for (int i=0;i<10000000;i++) {
            num = String.valueOf(i);
            for (int j=0;j<num.length()-2;j++) {
                if(num.charAt(j)=='6' && num.charAt(j+1)=='6' && num.charAt(j+2)=='6') {
                    temp++;
                    if(temp==cnt) {
                        result = Integer.parseInt(num);
                        return result;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        System.out.println(end(cnt));
    }
}
