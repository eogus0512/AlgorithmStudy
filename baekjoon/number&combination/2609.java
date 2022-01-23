import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, max, min, GCD, LCM, temp;
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        GCD = 0; LCM = a*b;
        max = a>b?a:b;
        min = a<b?a:b;

        //유클리드호제법
        while(min!=0) {
            temp = max%min;
            max = min;
            min = temp;
        }
        GCD = max;

        LCM /= GCD;
        System.out.println(GCD + "\n" + LCM);
    }
}