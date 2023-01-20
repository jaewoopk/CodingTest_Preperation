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
    static void bfs3() {
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        n = Integer.parseInt(st.nextToken());
        arr = new LinkedList[n + 1];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
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
    }
    static class Node {
        int e;
        int r;
        Node(int e, int r) {
            this.e = e;
            this.r = r;
        }
    }
}
