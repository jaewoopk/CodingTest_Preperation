package Baekjoon.Q2579;

import java.util.Scanner;

public class climbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sum[0] = arr[0];
        sum[1] = arr[0] + arr[1];
        sum[2] = Math.max(arr[2] + arr[0], arr[2] + arr[1]);

        for (int i = 3; i < n; i++) {
            sum[i] = Math.max(arr[i] + sum[i - 2], arr[i] + arr[i - 1] + arr[i - 3]);
        }
        for (var e : arr) {
            System.out.println(e);
        }
        sc.close();
    }
}
