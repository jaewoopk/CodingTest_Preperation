package SoftwareMaestro;

import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[11];
        int[] dp = new int[n + 1];

        dp[1] = 10;
        for (int i = 0; i < 11; i++) {
            arr[i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            int count = arr[10];
            for (int j = 9; j > 1; j--) {
                arr[j] += (arr[j + 1] % 10007);
                count += arr[j];
            }
            dp[i] = (count + dp[i - 1]) % 10007;
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
