package SWEA.D3.Q1208;

import java.util.*;
import java.io.*;

public class Q1208 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 11; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            System.out.println("#" + i + " " + (arr[99]-arr[0]));
        }
    }
}
