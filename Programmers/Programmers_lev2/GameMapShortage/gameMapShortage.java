package Programmers_lev2.GameMapShortage;

import java.util.*;


public class gameMapShortage {
    public static void main(String[] args) {
        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(Solution.solution(arr));
    }
}

class Solution {
    public static int[] xSet = {1,0,-1,0};
    public static int[] ySet = {0,1,0, -1};
    public static boolean[][] visited;
    public static int answer = 0;

    public static void bfs(int[][] maps, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = tmp.x + xSet[i];
                int y = tmp.y + ySet[i];

                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue ;
                }
                else if (maps[x][y] == 0) {
                    continue ;
                }
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    maps[x][y] = maps[tmp.x][tmp.y] + 1;
                    q.add(new Node(x,y));
                }
            }
        }
        answer = maps[n - 1][m - 1] != 1 ? maps[n - 1][m - 1] : -1;
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        visited = new boolean[n][m];

        bfs(maps, n, m);
        return answer;
    }
}

class Node {
    int x;
    int y;

    Node(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}
