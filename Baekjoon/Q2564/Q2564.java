package Baekjoon.Q2564;

import java.util.*;
import java.io.*;

public class Q2564 {
    static int n, m, sum;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static int[] getDirections(int[] tmp) {
        switch (tmp[0]) {
            case 1:
                return new int[] {0, tmp[1]};
            case 2:
                return new int[] {m, tmp[1]};
            case 3:
                return new int[] {tmp[1], 0};
        }
        return new int[] {tmp[1], n};
    }
    public static void makeBoard(int x, int y) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] = -1;
            }
        }

        board[x][y] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int rx = tmp.direction + dx[i];
                int ry = tmp.length + dy[i];

                if (rx > -1 && rx < m + 1
                        && ry > -1 && ry < n + 1
                        && board[rx][ry] == 0) {
                    board[rx][ry] += board[tmp.direction][tmp.length] + 1;
                    q.add(new Node(rx, ry));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int shop;
        Queue<Node> q = new LinkedList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        shop = Integer.parseInt(st.nextToken());

        board = new int[m + 1][n + 1];

        for (int i = 0; i < shop; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tmp = getDirections(tmp);
            q.add(new Node(tmp[0], tmp[1]));
        }

        int[] dongeun = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dongeun = getDirections(dongeun);
        makeBoard(dongeun[0], dongeun[1]);

        for (Node e : q) {
            sum += board[e.direction][e.length];
        }

        System.out.println(sum - shop);
    }
}

class Node {
    int direction;
    int length;

    Node(int _direction, int _length){
        this.direction = _direction;
        this.length = _length;
    }
}