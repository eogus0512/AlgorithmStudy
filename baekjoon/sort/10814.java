import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void merge(String[][] array, String[][] sort, int left, int mid, int right) {
        int indexL=left;
        int indexR=mid+1;
        int i=left;

        while (indexL<=mid && indexR<=right) {
            if (Integer.parseInt(array[indexL][0])<=Integer.parseInt(array[indexR][0]))
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
    public static void mergeSort(String[][] array, String[][] sort, int left, int right) {
        int mid;

        if (left<right) {
            mid = (left+right)/2;
            mergeSort(array, sort, left, mid);
            mergeSort(array, sort,mid+1, right);
            merge(array, sort, left, mid, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        String[][] member = new String[cnt][2];
        String[][] sort = new String[cnt][2];
        for (int i=0;i<cnt;i++)
            member[i]=br.readLine().split(" ");

        mergeSort(member, sort, 0, cnt-1);

        for (int i=0;i<cnt;i++)
            sb.append(member[i][0] + " " + member[i][1] + "\n");

        System.out.println(sb);
    }
}
