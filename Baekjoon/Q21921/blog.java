package Baekjoon.Q21921;

import java.util.*;
import java.io.*;

public class blog {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list;

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = x; i < n + 1; i++) {
            int key = (sum[i] - sum[i - x]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int answer = list.get(map.size() - 1);
        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(map.get(answer));
        }

    }
}

