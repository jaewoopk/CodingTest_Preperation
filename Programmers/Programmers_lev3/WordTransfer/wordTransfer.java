package Programmers_lev3.WordTransfer;

import java.util.*;

public class wordTransfer {
    public static void main(String[] args) {
        System.out.println(Solution.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}

class Solution {
    static boolean[] visited;

    static public boolean isContain(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    static public boolean wordCheck(String tmp, String arg) {
        int check = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) != arg.charAt(i)) {
                check++;
            }
        }
        if (check == 1) {
            return true;
        }
        return false;
    }

    static public int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, begin));

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && wordCheck(tmp.word, words[i])) {
                    visited[i] = true;
                    q.add(new Node(tmp.depth + 1, words[i]));
                }
                if (visited[i] && words[i].equals(target)) {
                    return tmp.depth + 1;
                }
            }
        }
        return 0;
    }


    static public int solution(String begin, String target, String[] words) {
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