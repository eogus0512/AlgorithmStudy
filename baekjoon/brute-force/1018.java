import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int chess(char[][] board, int wid, int ver) {
        int min1, min2;
        int min = wid * ver;

        for (int i=0; i<=ver-8; i++) {
            for (int j=0; j<=wid-8; j++) {
                min1=0;min2=0;
                for (int k=i; k<i+8; k++) {
                    for (int l=j; l<j+8; l++) {
                        if ((k%2 == l%2 && board[k][l]!='B') || (k%2 != l%2 && board[k][l]!='W')) {
                            min1++;
                        }
                        if ((k%2 == l%2 && board[k][l]!='W') || (k%2 != l%2 && board[k][l]!='B')) {
                            min2++;
                        }
                    }
                }
                if (min1>=min2 && min2<min)
                    min=min2;
                else if(min1<min2 && min1<min)
                    min=min1;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int vertical = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        char[][] board = new char[vertical][width];
        String str;
        int min;
        for (int i=0; i<vertical; i++) {
            str = br.readLine();
            for (int j=0; j<width; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        min = chess(board, width, vertical);
        System.out.println(min);
    }
}
