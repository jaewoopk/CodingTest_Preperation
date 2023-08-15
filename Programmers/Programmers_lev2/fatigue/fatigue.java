package Programmers_lev2.fatigue;

import java.util.*;

public class fatigue {
    public static void main(String[] args) {
        System.out.println(Solution.solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
    }
}

class Solution {
    static int max = 0;
    static boolean[] visited;
    public static void findMaxCount(int k, int[][] dungeons, int idx) {
        max = Math.max(max, idx);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                findMaxCount(k - dungeons[i][1], dungeons, idx + 1);
                visited[i] = false;
            }
        }
    }
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        findMaxCount(k, dungeons, 0);

        return max;
    }
}