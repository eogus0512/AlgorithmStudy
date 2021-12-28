import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void sort(int[] array, int cnt) {
        int temp;
        for (int i=0;i<cnt;i++) {
            for (int j=i+1;j<cnt;j++) {
                if (array[j]<array[i]){
                    temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] array = new int[cnt];
        for (int i=0;i<cnt;i++) {
            array[i]=Integer.parseInt(br.readLine());
        }
        sort(array, cnt);
        for (int i=0;i<cnt;i++) {
            sb.append(array[i] + "\n");
        }
        System.out.println(sb);
    }
}
