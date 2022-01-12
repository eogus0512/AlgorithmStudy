import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Zero {
    int row;
    int column;
    Zero(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] sudoku = new int[9][9];
    public static ArrayList<Zero> zero = new ArrayList<>();

    public static ArrayList<Integer> check(int column, int row) {
        boolean[] tf = new boolean[9];
        Arrays.fill(tf, true);
        ArrayList<Integer> num = new ArrayList<Integer>();

        //3x3 부분 스도쿠를 찾기 위한 변수 초기화
        int col_new = (column / 3) * 3;
        int row_new = (row / 3) * 3;

        for (int i=0;i<9;i++) { //가로, 세로 check!
            if (sudoku[row][i]!=0)
                tf[sudoku[row][i]-1]=false;
            if (sudoku[i][column]!=0)
                tf[sudoku[i][column]-1]=false;
        }
        for (int i=row_new;i<row_new+3;i++) { //3x3 check!
            for (int j=col_new;j<col_new+3;j++) {
                if (sudoku[i][j]!=0)
                    tf[sudoku[i][j]-1]=false;
            }
        }
        for (int i=0;i<9;i++) {
            if (tf[i]==true)
                num.add(i+1);
        }
        return num;
    }

    public static void backTracking(int cnt) {
        ArrayList<Integer> num;
        if (cnt==zero.size()) {
            for (int i=0;i<9;i++) {
                for (int j=0;j<9;j++)
                    sb.append(sudoku[i][j]).append(" ");
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        for (Zero z : zero) {
            num = check(z.column, z.row);
            for (Integer i : num) {
                sudoku[z.row][z.column] = i;
                backTracking(cnt+1);
                sudoku[z.row][z.column] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Zero z;
        String[] str;
        for (int i=0;i<9;i++) {
            str = br.readLine().split(" ");
            for (int j=0;j<9;j++) {
                sudoku[i][j] = Integer.parseInt(str[j]);
                if (sudoku[i][j]==0) {
                    z=new Zero(i, j);
                    zero.add(z);
                }
            }
        }

        backTracking(0);
    }
}