package Programmers_lev3.MazeEscapeOrder;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class mazeEscapeOrder {
    public static void main(String[] args) {
        System.out.println(Solution.solution(3,4,2,3,3,1,5));
        //System.out.println(Solution.solution(2,2,1,1,2,2,2));
    }
}

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] board;
    public static boolean isCheck(int x, int y, int n, int m) {
        return x > -1 && x < n && y > -1 && y < m;
    }

    public static String bfs(Node start, Node end, int k, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        q.add(start);

        while(!q.isEmpty()) {
            Node pollQ = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = pollQ.x + dx[i];
                int y = pollQ.y + dy[i];
                if (isCheck(x, y, n ,m)) {
                    Node tmp = new Node(x, y);
                    tmp.count = pollQ.count + 1;
                    tmp.str = new String(pollQ.str);
                    switch (i) {
                        case 0 :
                            tmp.str += "d";
                            break;
                        case 1 :
                            tmp.str += "l";
                            break;
                        case 2 :
                            tmp.str += "r";
                            break;
                        case 3 :
                            tmp.str += "u";
                            break;
                    }
                    if (tmp.count == k && x == end.x && y == end.y) {
                        pq.add(tmp.str);
                    } else if (tmp.count < k) {
                        q.add(tmp);
                    }
                    //System.out.println(tmp.str + " " + tmp.count);
                }

            }
        }
        //System.out.println(pq.toString());
        return pq.poll();
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        if ((k % 2 == 0 && (Math.abs(x - r) + Math.abs(y - c)) % 2 != 0)
        ||  (k % 2 != 0 && (Math.abs(x - r) + Math.abs(y - c)) % 2 == 0)) {
            return "impossible";
        }
        board = new int[n][m];

        return bfs(new Node(x - 1,y - 1), new Node(r - 1, c - 1), k, n, m);
    }
}

class Node {
    int x;
    int y;
    int count;

    String str;

    Node(int _x, int _y){
        this.x = _x;
        this.y = _y;
        this.count = 0;
        str = new String();
    }
}