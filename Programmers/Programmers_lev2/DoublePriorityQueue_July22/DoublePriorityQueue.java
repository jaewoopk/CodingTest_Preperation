package Programmers_lev2.DoublePriorityQueue_July22;

import java.util.*;

public class DoublePriorityQueue {
    public static void main(String[] args) {
//        for (var e : Solution.solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})) {
//            System.out.println(e);
//        }
        for (var e : Solution.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})) {
            System.out.println(e);
        }
    }
}

class Solution {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        PriorityQueue<Integer> revPq = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[] {0, 0};

        for (String str : operations) {
            String[] element = str.split(" ");
            String operator = element[0];
            int num = Integer.parseInt(element[1]);

            if (operator.equals("I")) {
                pq.offer(num);
                revPq.offer(num);
            } else {
                if (!pq.isEmpty()) {
                    if (num == 1) {
                        int max = revPq.poll();
                        pq.remove(max);
                    } else {
                        int min = pq.poll() ;
                        revPq.remove(min);
                    }
                }
            }
        }

        if (!pq.isEmpty()) {
            answer[0] = revPq.poll();
            answer[1] = pq.poll();
        }

        return answer;
    }
}