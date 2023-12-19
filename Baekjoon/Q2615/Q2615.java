package Baekjoon.Q2615;

import java.util.*;
import java.io.*;

public class Q2615 {
    static int color;
    static int[][] board;
    static boolean answer;
    public static boolean down(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (isInner(x + i, y)) {
                if (board[x + i][y] != color) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if ((isInner(x - 1, y) && board[x - 1][y] == color)
            || (isInner(x + 5, y) && board[x + 5][y] == color)) {
            return false;
        }
        return true;
    }

    public static boolean downRight(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (isInner(x + i, y + i)) {
                if (board[x + i][y + i] != color) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if ((isInner(x - 1, y - 1) && board[x - 1][y - 1] == color)
                || (isInner(x + 5, y + 5) && board[x + 5][y + 5] == color)) {
            return false;
        }

        return true;
    }

    public static boolean right(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (isInner(x, y + i)) {
                if (board[x][y + i] != color) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if ((isInner(x , y - 1) && board[x][y - 1] == color)
                || (isInner(x, y + 5) && board[x][y + 5] == color)) {
            return false;
        }
        return true;
    }

    public static boolean upRight(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (isInner(x - i, y + i)) {
                if (board[x - i][y + i] != color) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if ((isInner(x + 1, y - 1) && board[x + 1][y - 1] == color)
                || (isInner(x - 5, y + 5) && board[x - 5][y + 5] == color)) {
            return false;
        }
        return true;
    }

    public static boolean isInner(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }
    public static void findWinner(int x, int y) {
        if (down(x, y) || downRight(x, y) || upRight(x, y) || right(x, y)) {
            System.out.println(color);
            System.out.println((x + 1) + " " + (y + 1));
            answer = true;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[19][19];
        answer = false;
        for (int i = 0; i < 19; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 1) {
                    color = 1;
                    findWinner(i, j);
                } else if (board[i][j] == 2) {
                    color = 2;
                    findWinner(i, j);
                }
            }
        }
        if (!answer) {
            System.out.println(0);
        }

    }
}
