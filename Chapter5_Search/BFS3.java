package Chapter5_Search;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BFS3 {
    static LinkedList<Node>[] arr;
    static Queue<Node> queue;
    static boolean visited[];
    static long max;

    static void bfs3() {
        Node beforeNode = arr[1].peek();
        queue.add(beforeNode);
        visited[beforeNode.e] = true;

        while(!queue.isEmpty()) {
            Node p = queue.poll();
            for (var node : arr[p.e]) {
                if (!visited[node.e]) {
                    queue.add(node);
                    node.sum += (beforeNode.sum + node.r);
                    beforeNode = node;
                    visited[node.e] = true;
                    if (max < node.sum) {
                        max = node.sum;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        n = Integer.parseInt(st.nextToken());
        arr = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
            st = new StringTokenizer(br.readLine());
            int num;
            num = Integer.parseInt(st.nextToken());
            arr[num] = new LinkedList<>();
            while (true) {
                int e, r;
                e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break ;
                }
                r = Integer.parseInt(st.nextToken());

                Node newNode = new Node(e, r);
                arr[num].add(newNode);
            }
        }
        bfs3();
        System.out.println(max);
    }
    static class Node {
        int e;
        int r;
        int sum;
        Node(int e, int r) {
            this.e = e;
            this.r = r;
            this.sum = 0;
        }
    }
}
