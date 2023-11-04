package PCCP.PCCP1_3;

import java.util.*;
public class PCCP1_3 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {{3, 5}, {2, 4}}));
    }
}

class Solution {
    public static String recursive(int x, int n) {
        if (x == 1) {
            return "Rr";
        }
        int pow = (int)Math.pow(4, x - 1);
        String str = "Rr";

        if (pow / 4 > n - 1) {
            str = "RR";
        } else if (pow / 4 <= n - 1 && n - 1 < pow / 2) {
            str = recursive(x - 1, n - (pow / 4));
        } else if (((pow / 4) * 3) <= n - 1) {
            str = "rr";
        } else {
            str = recursive(x - 1, n - (pow / 4) * 2);
        }

        return str;
    }
    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 1) {
                answer[i] = "Rr";
            } else if (queries[i][1] == 1) {
                answer[i] = "RR";
            } else {
                answer[i] = recursive(queries[i][0], queries[i][1]);
            }
        }

        return answer;
    }
}
