package Programmers_lev2.MoreHot;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class moreHot {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {1,2,3,9,10,12},7));
    }
}

class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays
                .stream(scoville)
                .boxed()
                .collect(Collectors.toList()));
        int answer = 1;
        int hot = pq.poll() + (pq.poll() * 2);

        while (hot < K && !pq.isEmpty()) {
            pq.add(hot);
            hot = pq.poll() + (pq.poll() * 2);
            answer++;
        }
        if (pq.isEmpty()) {
            return -1;
        }

        return answer;
    }
}
