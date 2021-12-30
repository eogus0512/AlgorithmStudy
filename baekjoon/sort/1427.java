import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void merge(int[] sort, int[] array, int left, int mid, int right) {
        int indexL=left;
        int indexR=mid+1;
        int i=left;

        while (indexL<=mid && indexR<=right) {
            if (array[indexL]>array[indexR])
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
    public static void mergeSort(int[] array, int[] sort, int left, int right) {
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
        int cnt = Integer.parseInt(br.readLine());
        try{
            if (cnt>1000000000)
                throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String numStr=String.valueOf(cnt);
        int[] array=new int[numStr.length()];
        int[] sort=new int[numStr.length()];
        for (int i=0;i<numStr.length();i++) {
            array[i]=Character.getNumericValue(numStr.charAt(i));
        }
        mergeSort(array, sort, 0, numStr.length()-1);

        for (int j=0;j<numStr.length();j++) {
            sb.append(array[j]);
        }
        System.out.println(sb);

    }
}
