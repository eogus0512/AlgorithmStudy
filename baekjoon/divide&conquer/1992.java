import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

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
            sb.append("(");
            divide(size/2, row, column);
            divide(size/2, row, column+size/2);
            divide(size/2, row+size/2, column);
            divide(size/2, row+size/2, column+size/2);
            sb.append(")");
        } else {
            if (first==1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0;i<N;i++) {
            str = br.readLine();
            for (int j=0;j<N;j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        divide(N, 0, 0);
        System.out.println(sb);
    }
}
