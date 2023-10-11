package Baekjoon.Q2563;

import java.util.*;
import java.io.*;

public class Q2563 {
    static int[][] board;

    public static void drawBoard(int n, int m) {
        for (int i = n; i < n + 10; i++) {
            for (int j = m; j < m + 10; j++) {
                board[i][j] = 1;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        board = new int[101][101];
        int answer = 0;

        for (int i = 0; i < T;i++) {
            st = new StringTokenizer(br.readLine());
            int n, m;
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            drawBoard(n, m);
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                answer += board[i][j];
            }
        }
        System.out.println(answer);
    }
}
