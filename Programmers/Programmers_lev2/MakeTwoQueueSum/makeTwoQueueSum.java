package Programmers_lev2.MakeTwoQueueSum;

import java.util.*;
import java.util.stream.Collectors;

public class makeTwoQueueSum {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {3,2,7,2}, new int[] {4,6,5,1}));
    }
}

class Solution {
    static Queue<Integer> q1;
    static Queue<Integer> q2;
    static long sum1 = 0;
    static long sum2 = 0;
    static int count = 0;
    static int max;
    static void rule1() {
        sum1 -= q1.peek();
        sum2 += q1.peek();
        q2.add(q1.poll());
    }
    static void rule2() {
        sum1 += q2.peek();
        sum2 -= q2.peek();
        q1.add(q2.poll());
    }
    public static int solution(int[] queue1, int[] queue2) {
        q1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(LinkedList::new));
        q2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(LinkedList::new));

        for (Integer e : q1) sum1 += e;
        for (Integer e : q2) sum2 += e;

        max = Math.max(q1.size(),q2.size()) + q1.size() + q2.size();

        if ((sum1 + sum2) % 2 == 1) return -1;

        while (sum1 != sum2) {
            if (count > max) return -1;
            if (q2.isEmpty()) rule1();
            else if (q1.isEmpty()) rule2();
            else if (sum1 > sum2)  rule1();
            else rule2();
            count++;
        }

        return count;
    }
}
