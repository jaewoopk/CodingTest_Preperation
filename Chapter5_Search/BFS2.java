package Chapter5_Search;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class BFS2 {
    static int n,m;
    static int[][] arr;
    static Queue<Point> queue;
    static boolean[][] visit;

    static void bfs2() {
        visit[0][0] = true;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
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
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                arr[i][j] = sc.nextInt();
            }
        }

        bfs2();
        sc.close();
    }
}
