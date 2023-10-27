package Baekjoon.Q1189;

import java.util.*;
import java.io.*;

public class Q1189 {
    static int r,c,k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] board;
    static boolean[][] visited;
    static Node start, end;
    static HashMap<Integer, Integer> map;

    static boolean checkMap(int x, int y) {
        return x > -1 && y > -1 && x < r && y < c && board[x][y] != 'T';
    }
    static void dfs(Node tmp, int count) {
        if (tmp.x == end.x && tmp.y == end.y) {
            map.put(count + 1, map.computeIfAbsent(count + 1, v -> 0) + 1);
        }
        visited[tmp.x][tmp.y] = true;
        for (int i = 0; i < 4; i++) {
            int x = tmp.x + dx[i];
            int y = tmp.y + dy[i];
            if (checkMap(x,y) && !visited[x][y]) {
                visited[x][y] = true;
                dfs(new Node(x, y), count + 1);
                visited[x][y] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visited = new boolean[r][c];
        start = new Node(r - 1, 0);
        end = new Node(0, c - 1);
        map = new HashMap<>();

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(start, 0);

        System.out.println(map.getOrDefault(k, 0));
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
