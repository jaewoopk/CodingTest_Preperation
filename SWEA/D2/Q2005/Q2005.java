package SWEA.D2.Q2005;

import java.util.Scanner;

public class Q2005 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T, n;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            int[][] board = new int[n + 1][n + 1];
            board[0][0] = 1;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    board[i][j] = board[i - 1][j - 1] + board[i -1][j];
                }
            }
            System.out.println("#" + test_case);
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
