package Baekjoon.SSAFY.Q13460;

import java.util.*;
import java.io.*;

public class Q13460 {
    static class State {
        int rx, ry, bx, by, count;

        State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
    static int N, M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int[] move(int x, int y, int dx, int dy) {
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
        }
        return new int[]{x, y};
    }

    public static int bfs(State state) {
        Queue<State> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        q.add(state);

        while (!q.isEmpty()) {
            State tmp = q.poll();
            if (tmp.count > 10) return -1;
            if (board[tmp.rx][tmp.ry] == 'O' && board[tmp.bx][tmp.by] != 'O') return tmp.count;

            for (int i = 0; i < 4; i++) {
                int[] redResult = move(tmp.rx, tmp.ry, dx[i], dy[i]);
                int[] blueResult = move(tmp.bx, tmp.by, dx[i], dy[i]);

                if (board[blueResult[0]][blueResult[1]] == 'O') {
                    continue;
                }
                if (redResult[0] == blueResult[0] && redResult[1] == blueResult[1]) {
                    switch (i) {
                        case 0 :
                            if (tmp.rx > tmp.bx) redResult[0]++;
                            else blueResult[0]++;
                            break;
                        case 1 :
                            if (tmp.rx < tmp.bx) redResult[0]--;
                            else blueResult[0]--;
                            break;
                        case 2 :
                            if (tmp.ry > tmp.by) redResult[1]++;
                            else blueResult[1]++;
                            break;
                        case 3 :
                            if (tmp.ry < tmp.by) redResult[1]--;
                            else blueResult[1]--;
                            break;
                    }
                }
                if (!visited[redResult[0]][redResult[1]][blueResult[0]][blueResult[1]]) {
                    q.add(new State(redResult[0], redResult[1], blueResult[0], blueResult[1], tmp.count + 1));
                    visited[redResult[0]][redResult[1]][blueResult[0]][blueResult[1]] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        State state = new State(0,0,0,0, 0);
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                switch (board[i][j]) {
                    case 'R' :
                        state.rx = i;
                        state.ry = j;
                        break;
                    case 'B' :
                        state.bx = i;
                        state.by = j;
                        break;
                }
            }
        }
        System.out.println(bfs(state));
    }
}
