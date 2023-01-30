package Chapter7_Number_Theory;

import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[m + 1];
        arr[1] = 1;
        for (int i = 2; i < m + 1; i++) {
            for (int j = i + i; j < m + 1; j += i) {
                if (arr[j] == 1) {
                    continue ;
                }
                else {
                    arr[j] = 1;
                }
            }
        }
        for (int i = n; i < m + 1; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}
