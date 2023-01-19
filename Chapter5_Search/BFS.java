package Chapter5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static Queue<Integer> queue;

    static void bfs(int idx) {
        visited[idx] = true;
        queue.add(idx);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            int i = 0;
            System.out.print(p + " ");
            while (i < arr[p].size()) {
                if (visited[arr[p].get(i)] == false) {
                    queue.add(arr[p].get(i));
                    visited[arr[p].get(i)] = true;
                }
                i++;
            }
        }
    }

    static void dfs(int idx) {
        visited[idx] = true;
        for (int i = 0; i < arr[idx].size(); i++) {
            if (visited[arr[idx].get(i)] == true) {
                continue ;
            }
            System.out.print(arr[idx].get(i) + " ");
            dfs(arr[idx].get(i));
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        queue = new LinkedList<Integer>();
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for (int i = 1; i < m + 1; i++) {
            int v, e;
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr[v].add(e);
            arr[e].add(v);
        }
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arr[i]);
        }
        System.out.print(k + " ");
        dfs(k);
        System.out.println();
        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }
        bfs(k);
    }
}
