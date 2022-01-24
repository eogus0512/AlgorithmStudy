import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N, result=1;
        HashMap<String, Integer> hm;
        String[] str;
        String kind;

        for (int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());
            hm = new HashMap<>();
            for (int j=0;j<N;j++) {
                str = br.readLine().split(" ");
                kind = str[1];
                if (hm.containsKey(kind)) {
                    hm.put(kind, hm.get(kind)+1);
                } else {
                    hm.put(kind, 1);
                }
            }
            for (int h : hm.values())
                result *= h+1;
            sb.append(result-1).append("\n");
            result = 1;
        }
        System.out.println(sb);
    }
}