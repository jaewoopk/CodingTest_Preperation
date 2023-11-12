package Baekjoon.Q1072;

import java.util.*;
import java.io.*;

public class Q1072 {
    static final int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = max;
        int p = (int) (((double)y * 100) / x);

        if (p >= 99) {
            System.out.println(-1);
            return ;
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int midP = (int) (((double)(y + mid) * 100) / (x + mid));

            if (midP > p) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
