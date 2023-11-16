package SWEA.D3.Q2805;

import java.util.*;
import java.io.*;
public class Q2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][n];
            int sum = 0;

            for (int j = 0; j < n; j++) {
                board[j] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            for (int j = 0; j < n; j++) {
                int range = Math.abs(n / 2 - j);
                for (int k = range; k < n - range; k++) {
                    sum += board[j][k];
                }
            }

            System.out.println("#" + i + " " + sum);
        }
        br.close();
    }
}
