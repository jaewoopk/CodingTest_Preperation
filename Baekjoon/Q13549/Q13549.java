package Baekjoon.Q13549;

import java.util.*;
import java.io.*;
public class Q13549 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        arr[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = arr[i + 1] + 1;
        }

        for (int i = n; i < 100000; i++) {
            int num = i;
            int count = Math.min(arr[num + 1], Math.min(arr[num], arr[num - 1])) + 1;
            arr[num] = count;
            while (num < 100001) {
                num *= 2;
                if (num > 100000) break;
                arr[num] = count;
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
