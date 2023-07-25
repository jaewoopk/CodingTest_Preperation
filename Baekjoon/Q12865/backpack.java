package Baekjoon.Q12865;

import java.io.*;
import java.util.*;

public class backpack {
    static HashMap<Integer, Integer> map;
    static ArrayList<Integer> list;
    static int n, k, w, v, max = 0;
    public static void backtracking(int numbers, int sum, int idx) {
        if (numbers <= k && sum > max) {
            max = sum;
        }
        for (int i = idx; i < list.size(); i++) {
            if (numbers + i <= k) {
                backtracking(numbers + list.get(i), sum + list.);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            map.put(w, Math.max(map.getOrDefault(w,0),v));
        }
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

    }
}

// 1 2 3 4 5 6 7   ->> 10
// 1 2 3 4
// 1 2 4
// 1 2 5
// 1 2 6
// 1 2 7
// 1 3 4
// 1 3 5
// 1 3 6
// 1 4 5
// 1 5
// 1 6
// 1 7
// 2 3 4