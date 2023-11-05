package PCCP.PCCP1_4;

import java.util.*;
public class PCCP1_4 {
    public static void main(String[] args) {

    }
}

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        long count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        for (int[] e : program) {
            answer[0] += e[2];
            pq.add(new Node(e[0], e[1], e[2]));
        }

        while (answer[0] > count) {

        }

        return answer;
    }
}

class Node implements Comparable<Node>{
    int score;
    int start;
    int time;
    int realStart;

    Node (int _score, int _start, int _time) {
        this.score = _score;
        this.start = _start;
        this.time = _time;
        this.realStart = 0;
    }

    @Override
    public int compareTo(Node o) {
        if (this.start != o.start) {
            return Integer.compare(this.start, o.start);
        } else {
            return Integer.compare(this.score, o.score);
        }
    }

}