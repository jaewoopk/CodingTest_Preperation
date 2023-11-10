package PCCP.PCCP2_3;

import java.util.*;

class PCCP2_3_answer {
    public int solution(int[] menu, int[] order, int k) {
        PriorityQueue<Node2> pq = new PriorityQueue<>((a,b) -> a.k == b.k
                ? b.pos.compareTo(a.pos) : a.k - b.k);
        int time = 0;
        int people = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < order.length; i++) {
            int arrivalTime = i * k;
            if (time < arrivalTime) {
                time = arrivalTime;
            }
            pq.add(new Node2("arrive", arrivalTime));

            time += menu[order[i]];
            pq.add(new Node2("out", time));
        }

        while(!pq.isEmpty()) {
            Node2 tmp = pq.poll();

            if (tmp.pos.equals("arrive")) {
                people++;
            } else if (tmp.pos.equals("out")) {
                people--;
            }
            max = Math.max(max, people);
        }
        return max;
    }
}

class Node2 {
    String pos;
    int k;
    Node2(String _pos, int _k) {
        this.pos = _pos;
        this.k = _k;
    }
}


// input 값
// [5, 6, 7, 11]
// [1, 2, 3, 3, 2, 1, 1]
// 10
// output 값
// 2
