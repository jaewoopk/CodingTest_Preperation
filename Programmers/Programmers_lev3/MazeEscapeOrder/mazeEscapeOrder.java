package Programmers_lev3.MazeEscapeOrder;

public class mazeEscapeOrder {
    public static void main(String[] args) {

    }
}

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        if ((k % 2 == 0 && Math.abs(x - r + y - c) % 2 != 0)
        ||  (k % 2 != 0 && Math.abs(x - r + y - c) % 2 == 0)) {
            return "impossible";
        }
        int[][] board = new int[n][m];

        return answer;
    }
}
