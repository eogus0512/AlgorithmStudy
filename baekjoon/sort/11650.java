import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void merge(int[][] array, int[][] sort, int left, int mid, int right) {
        int indexL=left;
        int indexR=mid+1;
        int i=left;

        while (indexL<=mid && indexR<=right) {
            if (array[indexL][0]<array[indexR][0]) {
                sort[i][0] = array[indexL][0];
                sort[i++][1] = array[indexL++][1];
            }
            else if (array[indexL][0]==array[indexR][0])
                if (array[indexL][1]<array[indexR][1]) {
                    sort[i][0] = array[indexL][0];
                    sort[i++][1] = array[indexL++][1];
                }
                else {
                    sort[i][0] = array[indexR][0];
                    sort[i++][1] = array[indexR++][1];
                }
            else {
                sort[i][0] = array[indexR][0];
                sort[i++][1] = array[indexR++][1];
            }

        }
        if (indexL<=mid) {
            while (indexL<=mid) {
                sort[i][0] = array[indexL][0];
                sort[i++][1] = array[indexL++][1];
            }
        }
        if (indexR<=right) {
            while (indexR<=right) {
                sort[i][0] = array[indexR][0];
                sort[i++][1] = array[indexR++][1];
            }

        }
        for (int j=left;j<=right;j++) {
            array[j][0] = sort[j][0];
            array[j][1] = sort[j][1];
        }

    }
    public static void mergeSort(int[][] array, int[][] sort, int left, int right) {
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
        String[][] str = new String[cnt][2];
        int [][] coordinate = new int[cnt][2];
        int [][] sort = new int[cnt][2];

        for (int i=0;i<cnt;i++) {
            str[i] = br.readLine().split(" ");
        }
        for (int i=0;i<cnt;i++) {
            coordinate[i][0] = Integer.parseInt(str[i][0]);
            coordinate[i][1] = Integer.parseInt(str[i][1]);
        }
        mergeSort(coordinate, sort, 0, cnt-1);

        for (int i=0;i<cnt;i++) {
            sb.append(coordinate[i][0] + " ");
            sb.append(coordinate[i][1] + "\n");
        }
        System.out.println(sb);
    }
}
