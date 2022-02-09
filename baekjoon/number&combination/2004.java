import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static long squareTwo(long num) {
        long result=0, temp=num, square=2;
        while(temp>=square) {
            result += num/square;
            square *= 2;
        }
        return result;
    }
    public static long squareFive(long num) {
        long result=0, temp=num, square=5;
        while(temp>=square) {
            result += num/square;
            square *= 5;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long result = Math.min(squareTwo(n) - squareTwo(n-m) - squareTwo(m), squareFive(n) - squareFive(n-m) - squareFive(m));
        System.out.println(result);
    }
}