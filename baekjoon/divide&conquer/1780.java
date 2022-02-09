import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] arr;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static void divide(int size, int row, int column) {
        int first = arr[row][column];
        boolean isBreak = false;
        if (size>1) {
            for (int i=row;i<row+size;i++) {
                for (int j=column;j<column+size;j++) {
                    if (first != arr[i][j]) {
                        isBreak = true;
                        break;
                    }
                }
            }
        }
        if (isBreak) {
            divide(size/3, row, column);
            divide(size/3, row+size/3, column);
            divide(size/3, row+size*2/3, column);
            divide(size/3, row, column+size/3);
            divide(size/3, row+size/3, column+size/3);
            divide(size/3, row+size*2/3, column+size/3);
            divide(size/3, row, column+size*2/3);
            divide(size/3, row+size/3, column+size*2/3);
            divide(size/3, row+size*2/3, column+size*2/3);
        } else {
            if (first==-1) {
                minus++;
            } else if (first==0) {
                zero++;
            } else {
                plus++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0;i<N;i++) {
            str = br.readLine().split(" ");
            for (int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        divide(N, 0, 0);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}
