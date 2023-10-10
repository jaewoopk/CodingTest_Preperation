package SWEA.D2.Q2001;

import java.util.*;
import java.io.*;

class Q2001 {
    static int[][] board;
    static int[][] prefixSum;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int m, n;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            board = new int[m][m];
            prefixSum = new int[m + 1][m + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    prefixSum[i][j] = board[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i -1][j - 1];
                }
            }

            for (int i = 1; i <= m - n + 1; i++) {
                for (int j = 1; j <= m - n + 1; j++) {
                    int sum = prefixSum[n + i - 1][n + j - 1] - prefixSum[n + i - 1][j - 1] - prefixSum[i - 1][n + j - 1] + prefixSum[i - 1][j - 1];
                    max = Math.max(sum, max);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
