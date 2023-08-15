package Programmers_lev3.numTrinangle;

import java.lang.reflect.Array;
import java.util.Arrays;

public class numTriangle {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}}));
    }
}

class Solution {
    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length + 1][triangle.length + 1];
        int answer = 0;
        for (int i = 1; i < triangle.length + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i - 1][j - 1];
            }
        }

        for (int i = 1; i < triangle.length + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        for (int e : dp[triangle.length]) {
            answer = Math.max(answer, e);
        }
        return answer;
    }
}