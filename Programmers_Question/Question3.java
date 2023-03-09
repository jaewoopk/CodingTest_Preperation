package Programmers_Question;

import java.util.Queue;
import java.util.Vector;
import java.util.LinkedList;

public class Question3 {
    public static void main(String[] args) {

    }   
}

class Solution {
    Queue<Vector<Integer>> Q;
    boolean[] visited;
    int[] xArr = {1, 0, -1, 0};
    int[] yArr = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int answer = 0;
        int row = 0;
        for (String e : maps) {
            for (int i = 0; i < e.length(); i++) {
                if (e.charAt(i) == 'S') {
                    BFS(maps, row, i);
                }
            }
            row++;
        }
        return answer;
    }
    public void BFS(String[] maps, int row, int column) {
        Q = new LinkedList<>();



    }
}
