package Chapter7_Number_Theory;

import java.util.Scanner;

public class primeNumber4 {
    static long min, max, count = 0;
    static int realIdx = 0;
    static long[] arr;
    static long[] realArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        min = sc.nextLong();
        max = sc.nextLong();
        arr = new long[1010001];

        arr[1] = -1;
        for (long i = 2; i < 1010001; i++) {
            for (long j = i + i; j < 1010001; j += i) {
                if (arr[(int)j] == -1) {
                    continue ;
                }
                else {
                    arr[(int)j] = -1;
                }
            }
        }

        realArr = new long[1010001];
        for (long i = 2; i < 1010001; i++) {
            if (arr[(int)i] == 0) {
                realArr[realIdx++] = i * i;
            }
        }
        System.out.println(realIdx);
        for (long i = min; i < max + 1; i++) {
            findNN(i);
        }

        System.out.println(count);
        sc.close();
    }

    static void findNN(long x) {
        for (int i = 0; i < realIdx; i++) {
            if (x % realArr[i] == 0) {
                return ;
            }
            else if (realArr[i] > max) {
                count++;
                return ;
            }
        }
    }
}
