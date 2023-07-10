package Baekjoon.July6;

import java.util.*;
import java.awt.Point;

public class Q1996_mineSweeper {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int n;

    public static void plusArround(int x, int y, int value) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n)) {
                map[nx][ny] += value;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Point> q = new LinkedList<Point>();
        n = sc.nextInt();
        map = new int[n][n];
        char[][] answer = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) != '.') {
                    map[i][j] = str.charAt(j) - '0';
                    q.add(new Point(i, j));
                }
            }
        }
        for (Point e : q) {
            int x = e.x;
            int y = e.y;
            plusArround(x, y, map[x][y]);
        }
        for (Point e : q) {
            int x = e.x;
            int y = e.y;
            map[x][y] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) {
                    answer[i][j] = '*';
                } else if (map[i][j] >= 10) {
                    answer[i][j] = 'M';
                } else {
                    answer[i][j] = (char) (map[i][j] + '0');
                }
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}

// N = int(input())
// li = ['.'*(N+2)] + ['.'+input()+'.' for _ in range(N)] + ['.'*(N+2)]
// res = []
// for i in range(N):
//     i += 1
//     s = ''
//     for j in range(N):
//         j += 1
//         if ord('0') <= ord(li[i][j]) <= ord('9'):
//             s += '*'
//         else:
//             bomb = 0
//             for a in range(i-1, i+2):
//                 for b in range(j-1, j+2):
//                     if ord('0') <= ord(li[a][b]) <= ord('9'):
//                         bomb += int(li[a][b])
//             s += str(bomb) if bomb < 10 else "M"
//     res.append(s)
// for s in res:
//     print(s)