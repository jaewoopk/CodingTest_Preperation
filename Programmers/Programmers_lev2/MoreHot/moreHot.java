package Programmers_lev2.MoreHot;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class moreHot {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {1,2,3,9,10,12},7));
        System.out.println(Solution.solution(new int[] {1,2,3,9,10,12},10000));
    }
}

class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays
                .stream(scoville)
                .boxed()
                .collect(Collectors.toList()));
        int answer = 0;
        int len = pq.size();
        int pk = pq.peek();

        while (answer <= len && pk < K && pq.size() > 1) {
            //System.out.println(pq.toString());
            int hot = pq.poll() + (pq.poll() * 2);
            pq.add(hot);
            pk = pq.peek();
            answer++;
        }
        if (pq.size() == 1) {
            if (pq.peek() > K) {
                return answer;
            } else {
                return -1;
            }
        }

        return answer;
    }
}

//class Solution {
//    public static int solution(int[] scoville, int K) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays
//                .stream(scoville)
//                .boxed()
//                .collect(Collectors.toList()));
//
//        int answer = 0;
//        while (pq.peek() < K) {
//            if (pq.size() < 2) return -1;  // 2개 이하면 더 이상 조합 불가능
//
//            int mixed = pq.poll() + pq.poll() * 2;
//            pq.add(mixed);
//            answer++;
//        }
//
//        return answer;
//    }
//}