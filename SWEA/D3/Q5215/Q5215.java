package SWEA.D3.Q5215;

import java.util.*;
import java.io.*;

public class Q5215 {
    static int max;
    static int n;
    static int l;
    static int[][] arr;
    public static void dfs(int idx, int score, int cal) {
        if (cal > l){
            return;
        }
        if (idx >= n) {
            max = Math.max(max, score);
            return;
        }
        dfs(idx + 1, score + arr[idx][0], cal + arr[idx][1]);
        dfs(idx + 1, score, cal);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            arr = new int[n][2];
            max = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            dfs(0, 0, 0);
            System.out.println("#" + i + " " + max);
        }
    }
}

