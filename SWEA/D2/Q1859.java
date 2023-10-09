package SWEA.D2;

import java.util.*;
import java.io.*;

class Q1859 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long sum = 0;
            int max = arr[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    sum += (max - arr[i]);
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}