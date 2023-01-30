package Chapter7_Number_Theory;

import java.util.Scanner;

public class primeNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n, m;
        long count = 0;
        n = sc.nextLong();
        m = sc.nextLong();

        int im = (int)(Math.sqrt(m));
        long[] arr = new long[im + 1];
        arr[1] = 0;

        for (int i = 2; i < im + 1; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < im + 1; i++) {
            for (int j = i + i; j < im + 1; j += i) {
                if (arr[j] == 0) {
                    continue;
                }
                else {
                    arr[j] = 0;
                }
            }
        }
        for (int i = 2; i < im + 1; i++) {
            if (arr[i] != 0) {
                long temp = arr[i];
                while ((double)arr[i] <= (double)m/(double)temp) {
                    if ((double)arr[i] >= (double)n/(double)temp) {
                        count++;
                    }
                    temp *= arr[i];
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
