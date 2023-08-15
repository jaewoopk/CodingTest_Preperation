package Programmers_lev2.targetNumber;

import java.util.Arrays;

public class targetNumber {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {1,1,1,1,1}, 3));
    }
}

class Solution {
    static boolean[] visited;
    static int count;

    public static void dfs(int[] numbers, int idx, int sum, int target) {
        if (idx >= numbers.length) {
            if (target == sum) count++;
            return ;
        }
        dfs(numbers, idx + 1, sum + numbers[idx], target);
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new boolean[numbers.length];
        dfs(numbers,0, 0, target);
        return count;
    }
}