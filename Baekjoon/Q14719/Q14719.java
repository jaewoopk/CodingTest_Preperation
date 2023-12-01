package Baekjoon.Q14719;

import java.util.*;
import java.io.*;

public class Q14719 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[n][m];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= n - arr[i]; j--) {
                board[j][i] = 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            boolean leftChecker = false;
            int leftIdx = 0;
            for (int j = 0; j < m; j++) {
                if (j != m - 1 && !leftChecker && board[i][j] == 1 && board[i][j + 1] == 0) {
                    leftChecker = true;
                    leftIdx = j;
                } else if (j != 0 && leftChecker && board[i][j] == 1 && board[i][j - 1] == 0) {
                    for (int k = leftIdx + 1; k < j; k++) {
                        board[i][k] = 2;
                    }
                    leftChecker = false;
                    j--;
                    continue;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(board[i][j] + " ");
                if (board[i][j] == 2) {
                    count++;
                }
            }
//            System.out.println();
        }
        System.out.println(count);
    }
}

