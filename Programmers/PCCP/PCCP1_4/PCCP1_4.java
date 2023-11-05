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
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) ->a.time - b.time);
        PriorityQueue<Node> pq2 = new PriorityQueue<Node>((a,b) ->
                a.score != b.score ? a.score - b.score : a.time - b.time
        );

        for (int[] e : program) {
            answer[0] += e[2];
            pq.add(new Node(e[0], e[1], e[2]));
        }

        while (answer[0] > count) {

        }

        return answer;
    }
}

class Node{
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

}