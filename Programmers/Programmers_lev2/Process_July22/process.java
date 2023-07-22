package Programmers_lev2.Process_July22;

import java.util.*;

public class process {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {2, 1, 3, 2}, 2));
    }
}
class Solution {
    static Queue<Node> q;
    static Queue<Node> q2;
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int idx = 1;
        q = new LinkedList<>();
        q2 = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Node(priorities[i], i));
        }
        Arrays.sort(priorities);

        for (int i = priorities.length - 1; i >= 0; i--) {
            while (q.peek().data != priorities[i]) {
                q.offer(q.poll());
            }
            q2.add(q.poll());
        }

        while (!q2.isEmpty()) {
            if (q2.poll().location == location) {
                answer = idx;
                break ;
            }
            idx++;
        }
        return answer;
    }
}

class Node {
    int data;
    int location;
    Node (int _data, int _location){
        this.data = _data;
        this.location = _location;
    }
}
