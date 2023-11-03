package Baekjoon.Q11724;

import java.util.*;
import java.io.*;

public class Q11724 {
    static boolean[] visited;
    static int count;
    static HashMap<Integer, List<Integer>> hashMap;
    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()) {
            int tmp = q.poll();
            List<Integer> list = hashMap.get(tmp);
            if (list == null) continue;

            for (Integer e : list) {
                if (!visited[e]) {
                    visited[e] = true;
                    q.add(e);
                }
            }
        }
        count++;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        hashMap = new HashMap<>();

        int n, m;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            hashMap.computeIfAbsent(u, k -> new ArrayList<>());
            hashMap.get(u).add(v);
            hashMap.computeIfAbsent(v, k -> new ArrayList<>());
            hashMap.get(v).add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) bfs(i);
        }

        System.out.println(count);
        br.close();
    }
}
