package Baekjoon.Q1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1913 {
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        board[0][0] = n * n;
        for (int i = 1; i < n; i++) {
            board[i][0] = board[i - 1][0] - 1;
        }
        int idx = 0;
        int x = 0;
        int y = 0;
        /*for (int i = 0; i < n * n; i++) {
            x =
            board[i][idx] = board[]
        }*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == m) {
                    sb.append((i + 1) + " " + (j + 1));
                }
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.print(sb);
        br.close();
    }

}
