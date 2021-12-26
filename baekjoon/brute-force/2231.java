import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int decompose(int num) {
        int result=1000000, temp=0;
        for (int i=0; i<num; i++) {
            temp=i+i/1000000+i%1000000/100000+i%1000000%100000/10000+i%1000000%100000%10000/1000
                    +i%1000000%100000%10000%1000/100+i%1000000%100000%10000%1000%100/10+i%1000000%100000%10000%1000%100%10;
            if(num==temp && result>temp)
                result=i;
        }
        if(result==1000000)
            return 0;
        else
            return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = decompose(num);
        System.out.println(result);
    }
}
