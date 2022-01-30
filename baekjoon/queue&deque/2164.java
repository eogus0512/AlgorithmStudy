import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new LinkedList<>();
        Integer temp;
        int i = 0;

        for (int j=1;j<=N;j++) {
            arr.offerLast(j);
        }
        while(arr.size()!=1) {
            if (i%2==0) {
                arr.poll();
            } else {
                temp = arr.poll();
                arr.offerLast(temp);
            }
            i++;
        }
        System.out.println(arr.peek());
    }
}