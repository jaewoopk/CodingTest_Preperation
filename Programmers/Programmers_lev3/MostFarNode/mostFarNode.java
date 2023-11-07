package Programmers_lev3.MostFarNode;

import java.util.*;

public class mostFarNode {
    public static void main(String[] args) {
        System.out.println(Solution.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
class Solution {
    public static int[] bfs(int n, HashMap<Integer, List<Integer>> map) {
        Queue<Node> q = new LinkedList<>();
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        q.add(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (int e : map.get(tmp.num)) {
                if (!visited[e]) {
                    visited[e] = true;
                    q.add(new Node(e, tmp.count + 1));
                    arr[e] = tmp.count + 1;
                }
            }
        }
        return arr;
    }
    public static int solution(int n, int[][] edge) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edge.length; i++) {
            map.computeIfAbsent(edge[i][0], k -> new ArrayList<Integer>()).add(edge[i][1]);
            map.computeIfAbsent(edge[i][1], k -> new ArrayList<Integer>()).add(edge[i][0]);
        }
        int[] answer = bfs(n, map);
        Arrays.sort(answer);
        int max = answer[answer.length - 1];
        int count = 0;
        for (int e : answer) {
            if (e == max) {
                count++;
            }
        }
        return count;
    }
}

class Node {
    int num;
    int count;

    Node(int _num, int _count) {
        this.num = _num;
        this.count = _count;
    }
}
