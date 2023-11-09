package PCCP.PCCP2_2;


import java.util.*;

public class PCCP2_2 {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int answer = 0;

        for (int e : ability) {
            pq.add(e);
        }

        for (int i = 0; i < number; i++) {
            int x = pq.poll();
            int y = pq.poll();

            int sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}