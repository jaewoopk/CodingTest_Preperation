package Programmers_lev3.WorkSum;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class workSum {
    public static void main(String[] args) {
        System.out.println(Solution.solution(4, new int[] {4,3,3}));
        System.out.println(Solution.solution(1, new int[] {2,1,2}));
        System.out.println(Solution.solution(3, new int[] {1,1}));
        System.out.println(Solution.solution(12, new int[] {2,5,16}));
    }
}

class Solution {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = Arrays.stream(works).sum();

        for (int e : works) {
            pq.add(e);
        }
        while (n-- > 0 && sum-- > 0) {
            pq.add(pq.poll() - 1);
        }

        return pq.stream().mapToLong(i -> i * i).sum();
    }
}
