package SWEA.D3.Q1225;

import java.util.*;
import java.io.*;

public class Q1225 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < 8; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            int x = 1;
            while (true) {
                int tmp = dq.poll();
                if (tmp - x <= 0) {
                    dq.addLast(0);
                    break;
                }
                dq.addLast(tmp - x);
                x++;
                if (x >= 6) {
                    x = 1;
                }
            }
            System.out.print("#" + T + " ");
            while (!dq.isEmpty()) {
                System.out.print(dq.poll() + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
