package Chapter5_Search;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class BFS2 {
    static int n,m;
    static int[][] arr;
    static Queue<Point> queue;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void bfs2() {
        visit[0][0] = true;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int rX = (int) (p.getX() + dx[i]);
                int rY = (int) (p.getY() + dy[i]);
                if (rX < 0 || rY < 0 || rX > n - 1 || rY > m - 1) {
                    continue;
                }
                if (arr[rX][rY] == 1 && !visit[rX][rY]) {
                    arr[rX][rY] += arr[(int) p.getX()][(int) p.getY()];
                    visit[rX][rY] = true;
                    queue.add(new Point(rX, rY));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        queue = new LinkedList<Point>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs2();

        System.out.println(arr[n-1][m-1]);
        sc.close();
    }
}
