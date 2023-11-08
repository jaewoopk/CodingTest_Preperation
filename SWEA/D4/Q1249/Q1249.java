package SWEA.D4.Q1249;

import java.util.*;
import java.io.*;

class Q1249 {
    public void bfs() {

    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

        }
    }
}