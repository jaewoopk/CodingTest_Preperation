package SoftwareMaestro;

import java.util.Scanner;

public class Q18 {
    static int n, count;
    static boolean[][] check;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        count = 0;
        check = new boolean[n + 1][n + 1];
        board = new int[n + 1][n + 1];

        backTracking2(1);
        System.out.println(count);
        sc.close();
    }
    static void backTracking2(int idx) {
        if (idx == n + 1) {
            count++;
            return ;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!check[idx][i]) {
                checkingAll(idx, i);
                board[idx][i] = 1;
                drawBoard();
                backTracking2(idx + 1);
                board[idx][i] = 0;
                uncheckingAll(idx, i);
            }
        }
    }

    static void drawBoard() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (board[i][j] == 1) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        System.out.println("------------");
    }
    static void checkingAll(int yIdx, int xIdx) {
        for (int i = 0; i < n + 1 - yIdx; i++) {
            if (yIdx + i <= n) {
                check[yIdx + i][xIdx] = true;
            }
        }

        for (int i = 0; i < n + 1 - yIdx; i++) {
            if (xIdx - i > 0) {
                check[yIdx + i][xIdx - i] = true;
            }
        }
        for (int i = 0; i < n + 1 - yIdx; i++) {
            if (xIdx + i <= n) {
                check[yIdx + i][xIdx + i] = true;
            }
        }
    }

    static void uncheckingAll(int yIdx, int xIdx) {
        for (int i = 0; i < n + 1 - yIdx; i++) {
            if (yIdx + i <= n) {
                check[yIdx + i][xIdx] = false;
            }
        }

        for (int i = 0; i < n + 1 - yIdx; i++) {
            if (xIdx - i > 0) {
                check[yIdx + i][xIdx - i] = false;
            }
        }
        for (int i = 0; i < n + 1 - yIdx; i++) {
            if (xIdx + i <= n) {
                check[yIdx + i][xIdx + i] = false;
            }
        }
    }
}
