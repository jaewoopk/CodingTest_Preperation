package Baekjoon.Q2565;

import java.io.*;
import java.util.*;

public class electricLine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new LinkedList<>(map.keySet());
        Collections.sort(list);

        int comparison = 0;
        int count = 0;
        for (int e : list) {
            if (comparison > map.get(e)) {
                count++;
            }
            comparison = map.get(e);
        }
        System.out.println(count + 1);

    }
}

