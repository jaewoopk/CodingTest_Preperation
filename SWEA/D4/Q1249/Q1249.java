package SWEA.D4.Q1249;

import java.util.*;
import java.io.*;

class Q1249 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] map;
    static int n;
    static boolean[][] visited;
    public static boolean isInner(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];
                if (isInner(x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    map[x][y] += tmp.weight;
                    pq.add(new Node(x, y, map[x][y]));
                }
            }
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            dijkstra();
            System.out.println("#" + test_case + " " + map[n - 1][n - 1]);
        }
    }
}
class Node {
    int x;
    int y;
    int weight;
    Node(int _x, int _y, int _weight) {
        this.x = _x;
        this.y = _y;
        this.weight = _weight;
    }
}