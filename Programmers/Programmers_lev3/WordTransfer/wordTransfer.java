package Programmers_lev3.WordTransfer;

import java.util.*;

public class wordTransfer {
}

class Solution {
    boolean[] visited;

    public boolean isContain(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(Node(0, begin));

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && ) {

                }
            }
        }
    }


    public int solution(String begin, String target, String[] words) {
        if (!isContain(target, words)) {
            return 0;
        }

        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }
}

class Node {
    int depth;
    String word;

    Node(int _depth, String _word) {
        this.depth = _depth;
        this.word = _word;
    }
}