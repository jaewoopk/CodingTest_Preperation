package SWEA.D3.Q5260;

import java.util.Arrays;

public class Q5260 {
    static int findSubsetCount(int n, int k) {
        int[] dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= i; j--) {
                dp[j] += dp[j - i];
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[k];
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 5;

        System.out.println("m = " + findSubsetCount(n, k));
    }
}
