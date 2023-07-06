package Baekjoon.July6;

import java.util.*;
import java.awt.Point;

public class Q1996_mineSweeper {
    static int[][] map;
    static int[] xSet = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] ySet = {0, 1, 0, -1, 1, -1, 1, -1};
    static int n;
    static Character[][] answer;

    public static void plusArround(int x, int y, int value) {
        for (int i : xSet) {
            for (int j : ySet) {
                if ((x + i > 0 && x + i < n) ||
                    (y + j > 0 && y + j < n)) {
                    map[x + i][y + j] += value;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Point> q = new LinkedList<Point>();
        n = sc.nextInt();
        map = new int[n][n];
        answer = new Character[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) != '.') {
                    map[i][j] = Character.getNumericValue(str.charAt(j));
                    q.add(new Point(i,j));
                }
            }
        }
        for (Point e : q) {
            int x = (int)e.getX();
            int y = (int)e.getY();
            plusArround(x, y, map[x][y]);
            map[x][y] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) {
                    answer[i][j] = '*';
                }
                else if (map[i][j] >= 10) {
                    answer[i][j] = 'M';
                }
                else {
                    answer[i][j] = (char) ('0' + map[i][j]);
                }
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
