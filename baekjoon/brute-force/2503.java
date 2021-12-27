import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static boolean[] possible = new boolean[1000];

    public static void baseball(int num, int strike, int ball, int checkNum) {
        int strCnt=0;
        int ballCnt=0;
        for (int i=0;i<3;i++) {
            if (String.valueOf(num).charAt(i)==String.valueOf(checkNum).charAt(i))
                strCnt++;
        }
        for (int j=0;j<3;j++) {
            for (int k=0;k<3;k++) {
                if (j!=k && String.valueOf(num).charAt(j)==String.valueOf(checkNum).charAt(k))
                    ballCnt++;
            }
        }
        if (!(strCnt==strike && ballCnt==ball)) possible[checkNum] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] input;
        String numString;
        int num, strike, ball;
        int result = 0;
        Arrays.fill(possible, true);

        for (int i=0; i<cnt; i++) {
            input = br.readLine().split(" ");
            num = Integer.parseInt(input[0]);
            strike = Integer.parseInt(input[1]);
            ball = Integer.parseInt(input[2]);

            for (int j=123;j<=987;j++) {
                numString = String.valueOf(j);
                if (!(numString.charAt(0) == numString.charAt(1) || numString.charAt(1) == numString.charAt(2) || numString.charAt(0) == numString.charAt(2) || numString.charAt(0) == '0' || numString.charAt(1) == '0' || numString.charAt(2) == '0'))
                    baseball(num, strike, ball, j);
            }

        }
        for (int k=123;k<=987;k++) {
            numString = String.valueOf(k);
            if (possible[k] && !(numString.charAt(0) == numString.charAt(1) || numString.charAt(1) == numString.charAt(2) || numString.charAt(0) == numString.charAt(2) || numString.charAt(0) == '0' || numString.charAt(1) == '0' || numString.charAt(2) == '0')) {
                result++;
            }
        }
        System.out.println(result);
    }
}
