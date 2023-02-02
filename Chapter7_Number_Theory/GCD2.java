package Chapter7_Number_Theory;

import java.util.Scanner;

public class GCD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            if (b % a == 0) {
                System.out.println(b);
            }
            else {
                System.out.println(a * b / gcd(a,b));
            }
        }
        sc.close();
    }

    static int gcd(int a, int b) {
        int g = 1;
        while (b % a != 0) {
            g = b % a;
            b = a;
            a = g;
        }
        return g;
    }
}
