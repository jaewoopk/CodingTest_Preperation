package PCCP.PCCP2_3;

import java.util.*;

public class PCCP2_3 {
    public int solution(int[] menu, int[] order, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.k == b.k
                ? b.pos.compareTo(a.pos) : a.k - b.k);
        int time = 0;
        int people = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < order.length; i++) {
            time += menu[order[i]];
            pq.add(new Node("arrive", i * k));
            pq.add(new Node("out", time));
        }

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

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

class Node {
    String pos;
    int k;
    Node(String _pos, int _k) {
        this.pos = _pos;
        this.k = _k;
    }
}
