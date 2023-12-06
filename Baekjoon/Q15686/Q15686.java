package Baekjoon.Q15686;

import java.util.*;
import java.io.*;

public class Q15686 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Node> chickens = new LinkedList<>();
        List<Node> houses = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    houses.add(new Node(i, j));
                } else if (num == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        int[][] board = new int[chickens.size()][houses.size()];

        int i = 0;
        while (!chickens.isEmpty()){
            Node chicken = chickens.poll();
            for (int j = 0; j < houses.size(); j++) {
                Node house = houses.get(j);
                board[i][j] = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
            }
            i++;
        }
        for (i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
    static class Node {
        int x;
        int y;

        Node(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}
