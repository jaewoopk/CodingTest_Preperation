package Programmers_lev3.WorkSum;

import java.util.Arrays;
import java.util.PriorityQueue;

public class workSum {
    public static void main(String[] args) {
        System.out.println(Solution.solution(4, new int[] {4,3,3}));
    }
}

class Solution {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long answer = 0;

        for (int e : works) {
            pq.add(e);
        }

        while (n > 0) {

        }


        return answer;
    }
}
