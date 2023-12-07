package Baekjoon.Q15686;

import java.util.*;
import java.io.*;

public class Q15686 {
    static List<Node> chickens;
    static List<Node> houses;
    static boolean[] open;
    static int n, m;
    static int min = Integer.MAX_VALUE;
    public static void backTracking(int idx, int cnt) {
        if (m == cnt) {
            int sum = 0;
            for (int i = 0; i < houses.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (open[j]) {
                        tmp = Math.min(tmp, Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y));
                    }
                }
                sum += tmp;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            if (!open[i]) {
                open[i] = true;
                backTracking(i + 1, cnt + 1);
                open[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

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
        open = new boolean[chickens.size()];
        backTracking(0,0);
        System.out.println(min);
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
