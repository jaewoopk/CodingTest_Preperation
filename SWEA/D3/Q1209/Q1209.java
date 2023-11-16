package SWEA.D3.Q1209;

import java.util.*;
import java.io.*;

public class Q1209 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[][] board = new int[101][101];
            int[][] prefixSum = new int[101][101];
            int max = 0;
            int rDaeGak = 0;
            int lDaeGak = 0;
            for (int j = 1; j < 101; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < 101; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                    prefixSum[j][k] = prefixSum[j][k - 1] + prefixSum[j - 1][k] - prefixSum[j - 1][k - 1] + board[j][k];
                }
            }
            for (int j = 1; j < 101; j++) {
                int tmp = 0;
                rDaeGak += board[j][j];
                lDaeGak += board[j][101 - j];
                tmp = Math.max((prefixSum[j][100] - prefixSum[j - 1][100]), (prefixSum[100][j] - prefixSum[100][j - 1]));
                max = Math.max(max, tmp);
            }
            rDaeGak = Math.max(rDaeGak, lDaeGak);
            max = Math.max(rDaeGak, max);
            System.out.println("#" + T + " " + max);
        }
    }
}
