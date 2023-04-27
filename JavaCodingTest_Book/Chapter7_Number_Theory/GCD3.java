package Chapter7_Number_Theory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class GCD3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = sc.nextLong();
        long b = sc.nextLong();

        long ans = gcd2(a, b);

        for (long i = 0; i < ans; i++) {
            bw.write("1");
        }

        bw.flush();
        bw.close();
        sc.close();
    }

    static long gcd2(long a, long b) {
        if (a == 0) {
            return b;
        }
        else {
            return gcd2(b % a, a);
        }
    }
}
