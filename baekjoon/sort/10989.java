import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] accum = new int[10001];

    public static void countingSort(int[] array, int[] sort, int cnt) {
        for (int i=cnt-1; i>=0; i--) {
            sort[accum[array[i]]-1] = array[i];
            accum[array[i]]--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] array = new int[cnt];
        int[] sort = new int[cnt];
        Arrays.fill(accum, 0);
        for (int i=0;i<cnt;i++) {
            array[i]=Integer.parseInt(br.readLine());
            accum[array[i]]++;
        }
        for (int j=1;j<accum.length;j++) {
            accum[j] += accum[j-1];
        }

        countingSort(array, sort, cnt);

        for (int k=0;k<cnt;k++) {
            sb.append(sort[k] + "\n");
        }
        System.out.println(sb);
    }
}
