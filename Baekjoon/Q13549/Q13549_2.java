package Baekjoon.Q13549;

import java.util.*;
import java.io.*;

public class Q13549_2 {
    static int n, k;
    static int[] arr;

    static boolean isInner(int x) {
        return x >= 0 && x < 100001;
    }
    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int before = node.x - 1;
            int after = node.x + 1;
            int multiple = node.x * 2;

            if (isInner(multiple) && arr[multiple] > node.count) {
                pq.add(new Node(multiple, node.count));
                arr[multiple] = node.count;
            }
            if (isInner(before) && arr[before] > node.count + 1) {
                pq.add(new Node(before, node.count + 1));
                arr[before] = node.count + 1;
            }
            if (isInner(after) && arr[after] > node.count + 1) {
                pq.add(new Node(after, node.count + 1));
                arr[after] = node.count + 1;
            }
        }
        return arr[k];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        Arrays.fill(arr, 100000);
        System.out.println(dijkstra());

        br.close();
    }

}

class Node implements Comparable<Node> {
    int x;
    int count;

    Node (int _x, int _count) {
        this.x = _x;
        this.count = _count;
    }

    @Override
    public int compareTo(Node o) {
        return this.count - o.count;
    }
}
