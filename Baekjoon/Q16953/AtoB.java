package Baekjoon.Q16953;

import java.util.*;
import java.io.*;

public class AtoB {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static long min = Long.MAX_VALUE;

    public static long solution(long a, long b, int count) {
        if (a > b) {
            return -1;
        } else if (a == b){
            return min = Math.min(min, count);
        }
        solution(a * 2, b, count + 1);
        solution(a * 10 + 1, b, count + 1);
        return min;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(solution(a, b, 1) != Long.MAX_VALUE ? min : -1));
        bw.flush();
    }
}
