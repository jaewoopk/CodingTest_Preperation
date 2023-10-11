package Baekjoon.SSAFY.Q13460;

import java.util.*;

public class Answer {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    public static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.count > 10) return -1;
            if (board[current.rx][current.ry] == 'O' && board[current.bx][current.by] != 'O') return current.count;

            for (int i = 0; i < 4; i++) {
                int[] redResult = move(current.rx, current.ry, dx[i], dy[i]);
                int[] blueResult = move(current.bx, current.by, dx[i], dy[i]);

                if (board[blueResult[0]][blueResult[1]] == 'O') continue;
                if (redResult[0] == blueResult[0] && redResult[1] == blueResult[1]) {
                    switch (i) {
                        case 0: // up
                            if (current.rx > current.bx) redResult[0]++;
                            else blueResult[0]++;
                            break;
                        case 1: // down
                            if (current.rx < current.bx) redResult[0]--;
                            else blueResult[0]--;
                            break;
                        case 2: // left
                            if (current.ry > current.by) redResult[1]++;
                            else blueResult[1]++;
                            break;
                        case 3: // right
                            if (current.ry < current.by) redResult[1]--;
                            else blueResult[1]--;
                            break;
                    }
                }

                if (!visited[redResult[0]][redResult[1]][blueResult[0]][blueResult[1]]) {
                    queue.add(new State(redResult[0], redResult[1], blueResult[0], blueResult[1], current.count + 1));
                    visited[redResult[0]][redResult[1]][blueResult[0]][blueResult[1]] = true;
                }
            }
        }

        return -1;
    }

    public static int[] move(int x, int y, int dx, int dy) {
        int count = 0;
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            count++;
        }
        return new int[]{x, y};
    }
}
