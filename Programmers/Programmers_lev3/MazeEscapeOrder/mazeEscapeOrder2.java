package Programmers_lev3.MazeEscapeOrder;

public class mazeEscapeOrder2 {
    public static void main(String[] args) {
        //System.out.println(Solution2.solution(3,4,2,3,3,1,5));
        System.out.println(Solution2.solution(2,2,1,1,2,2,2));
    }
}

class Solution2 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    public static boolean isCheck(int x, int y, int n, int m) {
        return x > -1 && x < n && y > -1 && y < m;
    }
    public static String getStr(int i) {
        if (i == 0) return "d";
        if (i == 1) return "l";
        if (i == 2) return "r";
        return "u";
    }
    public static String greedy(Point start, Point end, int n, int m, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int x = start.x;
        int y = start.y;

        while (count < k) {
            boolean check = true;
            for (int i = 0; i < 4; i++) {
                int tmp_x = x + dx[i];
                int tmp_y = y + dy[i];
                if (tmp_x == end.x && tmp_y == end.y && count == k - 1) {
                    return sb.append(getStr(i)).toString();
                }
                if (isCheck(tmp_x, tmp_y, n , m)
                && (Math.abs(tmp_y - end.y) + Math.abs(tmp_x - end.x) <= k - count)) {
                    x = tmp_x;
                    y = tmp_y;
                    sb.append(getStr(i));
                    count++;
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
            if (!check) {
                return "impossible";
            }
        }
        return sb.toString();
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        if ((k % 2 == 0 && (Math.abs(x - r) + Math.abs(y - c)) % 2 != 0)
            || (k % 2 != 0 && (Math.abs(x - r) + Math.abs(y - c)) % 2 == 0)) {
            return "impossible";
        }

        return greedy(new Point(x - 1, y - 1), new Point(r - 1, c - 1), n, m, k);
    }
}

class Point {
    int x;
    int y;

    Point(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}