import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class Num {
    int first;
    int second;
    Num(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num num;
        ArrayList<Num> number = new ArrayList<Num>();
        String[] str;

        while(true) {
            str = br.readLine().split(" ");
            if (!str[0].equals("0") && !str[1].equals("0")) {
                num = new Num(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                number.add(num);
            } else {
                break;
            }
        }
        for (Num n : number) {
            if (n.second/n.first!=0 && n.second%n.first==0)
                System.out.println("factor");
            else if (n.first/n.second!=0 && n.first%n.second==0)
                System.out.println("multiple");
            else
                System.out.println("neither");
        }
    }
}