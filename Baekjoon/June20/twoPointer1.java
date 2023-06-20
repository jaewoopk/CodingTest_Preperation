package Baekjoon.June20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class twoPointer1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, x;
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int start = 0, end = n - 1;
        int count = 0;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                count++;
                start++;
                end--;
            }
            else if (arr[start] + arr[end] > x) {
                end--;
            }
            else {
                start++;
            }
        }
        System.out.println(count);
    }
}
