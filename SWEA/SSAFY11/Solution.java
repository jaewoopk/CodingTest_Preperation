package SWEA.SSAFY11;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
            while (!pq.isEmpty()) {
                int a = pq.poll();
                int size = pq.size();
                boolean check = false;
                while (size > 0) {
                    int b = pq.poll();
                    if (b >= a) {
                        q.add(b);
                    } else {
                        check = true;
                        break;
                    }
                    size--;
                }

                if (check || size == 0) {
                    sum += a;
                    while (!q.isEmpty()) {
                        pq.add(q.poll());
                    }
                } else {
                    while (!q.isEmpty()) {
                        pq.add(q.poll());
                    }
                    if (pq.isEmpty()) {
                        continue;
                    }
                    int b = pq.poll();
                    sum += (a + b);
                }

            }
            System.out.println("#" + i + " " + sum);
        }
    }
}