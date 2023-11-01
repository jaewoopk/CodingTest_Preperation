package Baekjoon.Q13549;

import java.util.*;
import java.io.*;
public class Q13549 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] dp = new int[200005];
        Arrays.fill(dp, 1000000);

        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
        }

        for (int i = n + 1; i < 200004; i++) {
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2], Math.min(dp[i - 1], dp[i + 1]) + 1);
            else dp[i] = Math.min(dp[i - 1] + 1, dp[i + 1] + 1);
        }

        for (int i = n + 1; i < 200004; i++) {
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2], Math.min(dp[i - 1], dp[i + 1]) + 1);
            else dp[i] = Math.min(dp[i - 1] + 1, dp[i + 1] + 1);
        }

        System.out.println(dp[k]);
    }
}
