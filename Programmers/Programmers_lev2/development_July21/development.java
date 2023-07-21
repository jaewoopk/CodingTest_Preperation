package Programmers_lev2.development_July21;

import java.util.*;

public class development {
    public static void main(String[] args) {
        for (var e : Solution.solution(new int[] {93, 30, 55}, new int[] {1, 3, 5})) {
            System.out.println(e);
        }
    }
}

class Solution {
    static int idx;
    static int count;
    static int tmp;
    static boolean isBig;
    static Integer value;

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int e : progresses) {
            count = 0;
            while (e < 100) {
                e += speeds[idx];
                count++;
            }
            q.add(count);
            idx++;
        }
        count = 0;
        value = q.peek();
        while (!q.isEmpty()) {
            tmp = q.poll();
            if (tmp > value) {
                value = tmp;
                isBig = true;
            }
            if (isBig) {
                list.add(count);
                count = 0;
                isBig = false;
            }
            count++;
        }
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
