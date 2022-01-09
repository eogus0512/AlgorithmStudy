import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void merge(String[] array, String[] sort, int left, int mid, int right) {
        int indexL=left;
        int indexR=mid+1;
        int i=left;

        while (indexL<=mid && indexR<=right) {
            if (array[indexL].length()<array[indexR].length())
                sort[i++] = array[indexL++];
            else if (array[indexL].length()==array[indexR].length()) {
                if (array[indexL].equals(array[indexR])) {
                    sort[i++] = array[indexL++];
                }
                else {
                    for (int j=0;j<array[indexL].length();j++) {
                        if (array[indexL].charAt(j)<array[indexR].charAt(j)) {
                            sort[i++] = array[indexL++];
                            break;
                        }
                        if (array[indexL].charAt(j)>array[indexR].charAt(j)) {
                            sort[i++] = array[indexR++];
                            break;
                        }
                    }
                }
            }
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
    public static void mergeSort(String[] array, String[] sort, int left, int right) {
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
        String[] word = new String[cnt];
        String[] sort = new String[cnt];
        for (int i=0;i<cnt;i++)
            word[i]=br.readLine();

        mergeSort(word, sort, 0, cnt-1);

        for (int i=0;i<cnt;i++) {
            if (i==0) {
                sb.append(word[i] + "\n");
            } else {
                if (!word[i-1].equals(word[i]))
                    sb.append(word[i] + "\n");
            }

        }


        System.out.println(sb);
    }
}
