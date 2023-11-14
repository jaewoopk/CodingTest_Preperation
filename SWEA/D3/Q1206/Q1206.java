package SWEA.D3.Q1206;

import java.util.*;
import java.io.*;
public class Q1206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 11; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 2; j < n - 2; j++) {
                int x = Math.max(Math.max(arr[j - 1], arr[j - 2]), Math.max(arr[j + 1], arr[j + 2]));
                if (arr[j] > x) {
                    sum += arr[j] - x;
                }
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}
