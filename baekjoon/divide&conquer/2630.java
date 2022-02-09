import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

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
            divide(size/2, row, column);
            divide(size/2, row+size/2, column);
            divide(size/2, row, column+size/2);
            divide(size/2, row+size/2, column+size/2);
        } else {
            if (first==1) {
                blue++;
            } else {
                white++;
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
        System.out.println(white);
        System.out.println(blue);
    }
}
