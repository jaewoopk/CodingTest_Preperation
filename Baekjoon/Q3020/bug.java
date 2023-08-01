package Baekjoon.Q3020;

import java.util.*;
import java.io.*;

public class bug {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int idx = 0;
        int min = 0;
        int value;
        int[] arr = new int[h + 1];
        int[] sum = new int[h + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            value = Integer.parseInt(st.nextToken());

            if (i % 2 == 0) {
                Arrays.fill(arr, 1, value + 1, 1);
            } else {
                Arrays.fill(arr, h - value + 1, h + 1, 1);
            }

            for (int j = 1; j < h + 1; j++) {
                sum[j] += arr[j];
            }
            Arrays.fill(arr, 0);
        }

        Arrays.sort(sum);
        min = sum[1];
        for (int i = 1; i < h + 1; i++) {
            if (min == sum[i]) {
                idx++;
            } else {
                break;
            }
        }
        System.out.println(min + " " + idx);
    }
}
