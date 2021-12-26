import java.util.Scanner;

public class Main {
    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();
        System.out.println(factorial(num));
        sc.close();
    }
}
