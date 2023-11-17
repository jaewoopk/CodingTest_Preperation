package Baekjoon.Q15649;

import java.util.*;
import java.io.*;

public class Q15649 {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    public static void backTracking(int idx) {
        if (idx == m) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                backTracking(idx + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n + 1];
        backTracking(0);
    }
}
