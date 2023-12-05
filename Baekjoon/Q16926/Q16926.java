package Baekjoon.Q16926;

import java.io.*;
import java.util.*;

public class Q16926 {
    static int[][] board;

    public static void recursive(int n, int m, int idx) {
        if (n / 2 <= idx || m / 2 <= idx) {
            return;
        }

        int x = idx;
        int y = idx;
        int tmp = board[idx + 1][idx];
        int beforeTmp = board[idx][idx];
        for (int i = 0; i < 2 * (n - idx * 2) + 2 * (m - idx * 2) - 4; i++) {
            if (y == idx && x < n - 1 - idx) {
                tmp = board[x + 1][y];
                board[x + 1][y] = beforeTmp;
                x++;
            } else if (x == n - 1 - idx && y < m - 1 - idx) {
                tmp = board[x][y + 1];
                board[x][y + 1] = beforeTmp;
                y++;
            } else if (y == m - 1 - idx && x > idx) {
                tmp = board[x - 1][y];
                board[x - 1][y] = beforeTmp;
                x--;
            } else if (x == idx && y > idx) {
                tmp = board[x][y - 1];
                board[x][y - 1] = beforeTmp;
                y--;
            }
            beforeTmp = tmp;
        }
        recursive(n, m, idx + 1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < r; i++) {
            recursive(n, m, 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
