import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] zero = new int[41];
    public static int[] one = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        zero[0]=1;zero[1]=0;
        one[0]=0;one[1]=1;
        int T = Integer.parseInt(br.readLine());
        int[] N = new int[T];
        for (int i=0;i<T;i++) {
            N[i] = Integer.parseInt(br.readLine());
        }
        for (int i=2;i<41;i++) {
            zero[i]=zero[i-2]+zero[i-1];
            one[i]=one[i-2]+one[i-1];
        }
        for (int i=0;i<T;i++) {
            sb.append(zero[N[i]]).append(" ").append(one[N[i]]).append("\n");
        }
        System.out.println(sb);
    }
}