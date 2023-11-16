package SWEA.D4.Q1210;

import java.util.*;
import java.io.*;
public class Q1210 {
    static int[][] board;
    static boolean[][] visited;
    public static boolean isInner(int x, int y) {
        return x >= 0 && y >= 0 && x < 100 && y < 100;
    }

    public static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.add(new Node(start.x, start.y));
        int x = 0, y = 0;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            x = tmp.x - 1;
            y = tmp.y;
            if (isInner(tmp.x, tmp.y + 1) && board[tmp.x][tmp.y + 1] == 1 && !visited[tmp.x][tmp.y + 1]) {
                x = tmp.x;
                y = tmp.y + 1;
            } else if (isInner(tmp.x, tmp.y - 1) && board[tmp.x][tmp.y - 1] == 1 && !visited[tmp.x][tmp.y - 1]) {
                x = tmp.x;
                y = tmp.y - 1;
            }

            if (isInner(x, y) && !visited[x][y]) {
                visited[x][y] = true;
                q.add(new Node(x, y));
            } else {
                break;
            }
        }
        return y;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int start = 0;
            board = new int[100][100];
            visited = new boolean[100][100];
            for (int j = 0; j < 100; j++) {
                board[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int j = 0; j < 100; j++) {
                if (board[99][j] == 2) {
                    start = j;
                    break;
                }
            }

            System.out.println("#" + T + " " + bfs(new Node(99, start)));
        }

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