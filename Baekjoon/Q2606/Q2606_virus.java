package Baekjoon.Q2606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q2606_virus {
    static int count;
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> map;
    public static void dfs(int key) {
        visited[key] = true;
        if (!map.containsKey(key)) {
            return ;
        }
        for (int e : map.get(key)) {
            if (!visited[e]) {
                dfs(e);
                count++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        map = new HashMap<>();
        visited = new boolean[n + 1];

        for (int i = 0; i < s; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            ArrayList<Integer> list1;
            ArrayList<Integer> list2;
            //map.computeIfAbsent(key, vlaue)
            if (!map.containsKey(key)) {
                list1 = new ArrayList<>();
            }
            else {
                list1 = map.get(key);
            }
            if (!map.containsKey(value)) {
                list2 = new ArrayList<>();
            }
            else {
                list2 = map.get(value);
            }
            list1.add(value);
            list2.add(key);
            map.put(key, list1);
            map.put(value, list2);
        }
        dfs(1);
        System.out.println(count);
        sc.close();
    }
}
