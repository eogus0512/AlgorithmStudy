import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
    static int[][] matrix;
    static int[] houseNum;
    static int[] directX = {0, 0, 1, -1};
    static int[] directY = {1, -1, 0, 0};
    static int N, apartNum = 0;;
    public static void dfs(int row, int column) {
        visited[row][column] = true;
        houseNum[apartNum]++;

        for (int i=0;i<4;i++) {
            int x = directX[i] + row;
            int y = directY[i] + column;
            if (x>=0 && y>=0 && x<N && y<N) {
                if (matrix[x][y]==1 && visited[x][y]==false)
                    dfs(x, y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];
        houseNum = new int[N*N];
        for (int i=0;i<N;i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i=0;i<N;i++) {
            str = br.readLine();
            for (int j=0;j<N;j++) {
                matrix[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (matrix[i][j]==1 && visited[i][j]==false) {
                    dfs(i, j);
                    apartNum++;
                }
            }
        }
        Arrays.sort(houseNum);
        System.out.println(apartNum);
        for (int i=0;i<houseNum.length;i++) {
            if (houseNum[i]!=0) {
                System.out.println(houseNum[i]);
            }
        }
    }
}

