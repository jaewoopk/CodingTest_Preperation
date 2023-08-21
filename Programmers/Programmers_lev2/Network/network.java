package Programmers_lev2.Network;

import java.util.*;

public class network {
    public static void main(String[] args) {
        System.out.println(Solution.solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(Solution.solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
    }
}

class Solution {
    static boolean[] visited;
    static HashMap<Integer, List<Integer>> map;

    public static void dfs(int idx) {
        for (int i = 0; i < map.get(idx).size(); i++) {
            if (!visited[map.get(idx).get(i)]) {
                visited[map.get(idx).get(i)] = true;
                dfs(map.get(idx).get(i));
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        map = new HashMap<>();
        visited = new boolean[computers[0].length];

        for (int i = 0; i < computers.length; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    list.add(j);
                }
            }
            map.put(i, list);
            //System.out.println(Arrays.toString(list.toArray()));
        }
        for (int i = 0; i < map.size(); i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}
