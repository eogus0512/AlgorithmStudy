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
            if (array[indexL]<array[indexR])
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
            if (cnt%2==0)
                throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double average=0;
        int median, mode=0, range, m=cnt/2, max=0;
        //int a=0, b=0;
        boolean isSecond=false;
        int[] array = new int[cnt];
        int[] sort = new int[cnt];
        int[] modeArr = new int[80001];
        Arrays.fill(modeArr, 0);
        for (int i=0;i<cnt;i++) {
            array[i]=Integer.parseInt(br.readLine());
            try{
                if (Math.abs(array[i])>4000)
                    throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mergeSort(array, sort, 0, cnt-1);

        for (int j=0;j<cnt;j++) {
            average += (double)array[j];
        }
        average /= cnt;
        median = array[m];

        for (int k=0;k<cnt;k++) {
            modeArr[array[k]+4000]++;
        }

        for (int l=0;l<8001;l++) {
            if(modeArr[l]>max)
                max=modeArr[l];
        }
        for (int l=0;l<8001;l++) {
            if(modeArr[l]==max && isSecond==false) {
                mode=l-4000;
                isSecond=true;
            } else if(modeArr[l]==max && isSecond==true) {
                mode=l-4000;
                break;
            }
        }

        /*
        for (int k=0;k<cnt;k++) {
            if (k==0) {
                a++;
                mode=array[k];
            } else if (k==cnt-1) {
                if (array[k] == array[k-1]) {
                    a++;
                }
                if (a > b) {
                    b = a;
                    mode = array[k];
                    isSecond = false;
                } else if (a == b && isSecond == false) {
                    mode = array[k];
                    isSecond = true;
                }
            } else if (array[k] == array[k-1]) {
                a++;
            } else {
                if (a>b) {
                    b=a;
                    mode=array[k-1];
                    isSecond = false;
                } else if (a==b && isSecond==false) {
                    mode=array[k-1];
                    isSecond = true;
                }
                a=1;
            }
        }
        */

        range = array[cnt-1]-array[0];

        sb.append(Math.round(average) + "\n" + median + "\n" + mode + "\n" + range);
        System.out.println(sb);
    }
}
