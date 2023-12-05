package Baekjoon.Q7490;

import java.util.*;
import java.io.*;

public class Q7490 {
    static int n;
    static StringBuilder sb;
    public static void combination(int idx, int num, int sum, int op, String str) {
        if (idx == n) {
            sum += (num * op);
            if (sum == 0) {
                sb.append(str)
                  .append("\n");
            }
            return;
        }

        combination(idx + 1, num * 10 + idx + 1, sum, op, str + " " + Integer.toString(idx + 1));
        combination(idx + 1, idx + 1, sum + (num * op), 1, str + "+" + Integer.toString(idx + 1));
        combination(idx + 1, idx + 1, sum + (num * op), -1, str + "-" + Integer.toString(idx + 1));
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            combination(1, 1,0, 1,"1");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
