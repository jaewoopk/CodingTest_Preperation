package Programmers_lev2.June30;

import java.util.Arrays;

public class hIndex {
    public static void main(String[] args) {
        System.out.println(Solution630_1.solution(new int[] {3,0,6,1,5}));
        System.out.println(Solution630_1.solution(new int[] {0,1,2,4,5,7,8,9}));
        System.out.println(Solution630_1.solution(new int[] {9,9,9,9,9,9,9,9}));
        System.out.println(Solution630_1.solution(new int[] {1,1,3,7,8,10,15}));
        System.out.println(Solution630_1.solution(new int[] {2,2,6,10,12}));
        System.out.println(Solution630_1.solution(new int[] {1,1,1,1,2,3}));
    }
}

class Solution630_1 {
    public static int solution(int[] citations) {
        int n = citations.length;
        int[] cmp = new int[n];
        for (int i = 1; i < n + 1; i++) {
            cmp[i - 1] = n - i + 1;
        }

        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (cmp[i] <= citations[i]) return cmp[i];
        }
        return 0;
    }
}