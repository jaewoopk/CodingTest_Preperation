package Baekjoon.Q14888;

import java.util.Scanner;

public class Q14888_putNumber {
    static int n;
    static int[] arr;
    static int[] op = {0, 0, 0, 0};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void bruteforce(int idx, int sum) {
        if (idx == n) {
            if (sum > max) max = sum;
            if (sum < min) min = sum;
            return ;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) bruteforce(idx + 1, sum + arr[idx]);
                else if (i == 1) bruteforce(idx + 1, sum - arr[idx]);
                else if (i == 2) bruteforce(idx + 1, sum * arr[idx]);
                else if (i == 3) bruteforce(idx + 1, sum / arr[idx]);
                op[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }
        bruteforce(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
        sc.close();
    }
}
