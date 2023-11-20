package SWEA.D4.Q2;

import java.util.*;
import java.io.*;

public class Solution2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int e : arr) {
                map.computeIfAbsent(e, k -> 0);
                map.put(e, map.get(e) + 1);
            }
            int[] tmp = new int[map.size() - 2];

            int count = 0;
            for (int e : map.keySet()) {
                if (count == 0 || count == map.size() - 1) {
                    count++;
                    continue;
                }
                tmp[count - 1] = map.get(e);
                count++;
            }
            int max = 0;
            if (tmp.length == 1) {
                max = tmp[0];
            }
            for (int j = 0; j < tmp.length - 1; j++) {
                int sum = tmp[j];
                for (int k = j + 1; k < tmp.length; k++) {
                    if (b < sum + tmp[k]) {
                        break;
                    }
                    sum += tmp[k];
                }
                max = Math.max(max, sum);
            }
            max = Math.max(max, tmp[tmp.length - 1]);

            System.out.println("#" + i + " " + max);
        }
    }
}