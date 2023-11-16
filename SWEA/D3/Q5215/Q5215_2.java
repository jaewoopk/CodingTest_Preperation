package SWEA.D3.Q5215;

import java.util.*;
import java.io.*;

public class Q5215_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];
            int[][] dp = new int[l + 1][n + 1];
            for (int j = 0; j < n; j++) {
                arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int j = 1; j < n + 1; j++) {
                for (int k = 0; k < l + 1; k++) {
                    if (k < arr[j - 1][1]) {
                        dp[k][j] = dp[k][j - 1];
                    } else {
                        dp[k][j] = Math.max(dp[k][j - 1], dp[k - arr[j - 1][1]][j - 1] + arr[j - 1][0]);
                    }
                }
            }

            System.out.println("#" + i + " " + dp[l][n]);
        }
    }
}

