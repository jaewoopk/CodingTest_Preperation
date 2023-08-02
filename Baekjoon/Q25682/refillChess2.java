package Baekjoon.Q25682;

import java.util.*;
import java.io.*;

public class refillChess2 {
    static int n, m, k;
    static int[][] board;
    static int[][] sumBoard;

    public static int findCount() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = k; j < m + 1; j++) {
                int countIfBlackFirst = 0;
                int countIfWhiteFirst = 0;
                for (int h = 0; h < k; h++) {
                    if (h % 2 == 0) {
                        countIfBlackFirst += (sumBoard[h + i][j] - sumBoard[h + i][j - k]) - (k + 1) / 2;
                        countIfWhiteFirst += (sumBoard[h + i][j] - sumBoard[h + i][j - k]) - k / 2;
                    } else {
                        countIfBlackFirst += (sumBoard[h + i][j] - sumBoard[h + i][j - k]) - k / 2;
                        countIfWhiteFirst += (sumBoard[h + i][j] - sumBoard[h + i][j - k]) - (k + 1) / 2;
                    }
                }
                System.out.println(countIfBlackFirst + " " + countIfWhiteFirst);
                min = Math.min(min, Math.min(countIfBlackFirst, countIfWhiteFirst));
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n + 2][m + 2];
        sumBoard = new int[n + 2][m + 2];

        for (int i = 1; i < n + 1; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(s -> s.equals("B") ? 1 : 0).toArray();
            System.arraycopy(row, 0, board[i], 1, m);
            for (int j = 1; j < m + 1; j++) {
                sumBoard[i][j] = sumBoard[i][j - 1] + sumBoard[i - 1][j] - sumBoard[i - 1][j - 1] + board[i][j];
            }
        }

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                System.out.print(sumBoard[i][j] + " ");
            }
            System.out.println();
        }


    }
}
