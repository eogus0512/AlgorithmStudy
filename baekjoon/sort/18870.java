import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void merge(int[][] sort, int[][] array, int left, int mid, int right) {
        int indexL=left;
        int indexR=mid+1;
        int i=left;

        while (indexL<=mid && indexR<=right) {
            if (array[indexL][0]<array[indexR][0])
                sort[i++] = array[indexL++];
            else
                sort[i++] = array[indexR++];
        }
        if (indexL<=mid) {
            while (indexL<=mid)
                sort[i++] = array[indexL++];
        }
        if (indexR<=right) {
            while (indexR<=right)
                sort[i++] = array[indexR++];
        }
        for (int j=left;j<=right;j++) {
            array[j] = sort[j];
        }

    }
    public static void mergeSort(int[][] array, int[][] sort, int left, int right) {
        int mid;

        if (left<right) {
            mid = (left+right)/2;
            mergeSort(array, sort, left, mid);
            mergeSort(array, sort,mid+1, right);
            merge(sort, array, left, mid, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        int a=1;
        int[][] simple = new int[cnt][2];
        int[][] array = new int[cnt][2];
        int[][] sort = new int[cnt][2];
        String[] str = new String[cnt];

        str=br.readLine().split(" ");
        for (int i=0;i<cnt;i++) {
            simple[i][0] = Integer.parseInt(str[i]);
            simple[i][1] = 0;
            array[i][0] = simple[i][0];
            array[i][1] = 0;
        }

        mergeSort(array, sort, 0, cnt-1);

        for (int i=1;i<cnt;i++) {
            if (array[i][0]!=array[i-1][0]) {
                array[i][1]=a++;
            } else
                array[i][1]=a-1;
        }

        for (int i=0;i<cnt;i++) {
            for (int j=0;j<cnt;j++) {
                if (simple[i][0]==array[j][0]) {
                    simple[i][1]=array[j][1];
                    sb.append(simple[i][1] + " ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
