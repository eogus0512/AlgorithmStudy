import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static StringBuilder sb =  new StringBuilder();

    public static int blackJack(int[] num, int card, int max) {
        int result=0;
        for (int i=0; i<card; i++) {
            for (int j=0; j<card; j++) {
                if (j!=i) {
                    for (int k=0; k<card; k++) {
                        if (k!=i && k!=j) {
                            if (max>=num[i]+num[j]+num[k] && num[i]+num[j]+num[k]>result)
                                result=num[i]+num[j]+num[k];
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int card = Integer.parseInt(info[0]);
        int max = Integer.parseInt(info[1]);
        String[] numStr = br.readLine().split(" ");
        int[] num = new int[card];
        int result = 0;

        for (int i=0; i<card; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }
        result = blackJack(num, card, max);
        System.out.println(result);
    }
}
