package PCCP.PCCP_REAL2;

import java.util.*;

class Solution {
    static boolean[][] visited;
    static HashSet<Integer> tryToAddInArr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 , -1};
    static int n, m;
    static int[] arr;

    public boolean isInner(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public void bfs(int _x, int _y, int[][] land) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(_x, _y));
        int area = 1;

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];
                if (isInner(x, y) && !visited[x][y] && land[x][y] == 1) {
                    visited[x][y] = true;
                    q.add(new Node(x, y));
                    area++;
                    tryToAddInArr.add(y);
                }
            }
        }

        for (Integer e : tryToAddInArr) {
            arr[e] += area;
        }
    }

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        arr = new int[m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    tryToAddInArr = new HashSet<>();
                    visited[i][j] = true;
                    tryToAddInArr.add(j);
                    bfs(i, j, land);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int e : arr) {
            max = (max < e) ? e : max;
        }

        return max;
    }

    class Node {
        int x;
        int y;

        Node(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}
