package Baekjoon.Q2644;

import java.util.*;
import java.io.*;

public class Q2644_degree {
    static int n, m;
    static int num1, num2;
    static HashMap<Integer, LinkedList<Integer>> map;
    static boolean[] visited;

    public static int bfs(int start, int end) {
        Queue<Integer> q = map.getOrDefault(start, new LinkedList<Integer>());
        visited[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int e = q.poll();
            if (!visited[e]) {
                visited[e] = true;
                LinkedList<Integer> list = map.getOrDefault(e, null);
                count++;
                for (int s : list) {
                    if (visited[s]) {
                        count--;
                    }
                }
            }
            if (e == end) return count;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        map = new HashMap<>();
        n = sc.nextInt();
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();

            map.computeIfAbsent(key, k -> new LinkedList<>()).add(value);
            map.computeIfAbsent(value, k -> new LinkedList<>()).add(key);
        }

        System.out.println(bfs(num1, num2));
        sc.close();
    }
}
