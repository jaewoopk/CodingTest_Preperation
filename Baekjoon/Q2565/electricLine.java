package Baekjoon.Q2565;

import java.io.*;
import java.util.*;

public class electricLine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }

        List<Integer> keyList = new LinkedList<>(map.keySet());
        Collections.sort(keyList);
        int comp = map.get(keyList.get(0));
        int up = 0;
        int down = 0;
        for (int e : keyList) {
            if (map.get(e) > comp) {
                up++;
                if (keyList.get(1) == e) {
                    down--;
                    up++;
                }
            } else {
                down++;
            }
            comp = map.get(e);
        }
        System.out.println(Math.min(up, down));
    }
}

