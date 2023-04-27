package Chapter7_Number_Theory;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;

        for (long i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                result -= (result / i);
            }
            while (n % i == 0) {
                n /= i;
            }
        }

        if (n > 1) {
            result -= (result / n);
        }
        System.out.println(result);
        sc.close();
    }
}

// public class GCD {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         long n = sc.nextLong();
//         n -= 100000;
//         long[] arr = new long[100002];

//         arr[1] = 1;
//         for (long i = n + 1; i < n + 100001; i++) {
//             arr[(int)(i - n + 1)] = i;
//         }

//         for (long i = n + 1; i < n + 100001; i++) {
//             if (arr[(int)(i - n + 1)] == i) {
//                 for (long j = i; j < n + 1; j += (i - n + 1)) {
//                     arr[(int)(j - n + 1)] -= ((int)(j - n + 1) / (i - n + 1));
//                 }
//             }
//         }

//         System.out.println(arr[100000]);
//         sc.close();
//     }
// }
