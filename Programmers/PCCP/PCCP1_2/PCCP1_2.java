package PCCP.PCCP1_2;

public class PCCP1_2 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {{3, 4}}));
    }
}

class Solution {
    static int max = Integer.MIN_VALUE;
    static int x, y;
    static boolean[] xVisited;

    public static void backtracking(int[][] ability, int k, int sum) {
        if (k == y && sum > max) {
            max = sum;
            return ;
        } else if (k >= y) {
            return ;
        }


        for (int i = 0; i < x; i++) {
            if (!xVisited[i]) {
                xVisited[i] = true;
                backtracking(ability, k + 1, ability[i][k] + sum);
                xVisited[i] = false;
            }
        }
    }

    public static int solution(int[][] ability) {
        x = ability.length;
        y = ability[0].length;

        xVisited = new boolean[x];

        backtracking(ability, 0, 0);

        return max;
    }
}
