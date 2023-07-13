package Baekjoon.July13;

import java.util.Scanner;

public class Q14889_startlink {
    static int[][] arr;
    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] values;

    public static void calculate(int start, int link) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n / 2 - 1; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                sum1 += arr[values[start + i]][values[start + j]];
                sum2 += arr[values[link + i]][values[link + j]];
            }
        }
        int comp = Math.abs(sum1 - sum2);
        min = Math.min(min, comp);
    }
    
    public static void backtracking(int idx) {
        if (idx == n + 1) {
            calculate(1, n / 2 + 1);
            return ;
        }
        for (int i = idx; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                values[idx] = i;
                backtracking(idx + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1][n + 1];
        values = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                arr[i][j] += arr[j][i];
                arr[j][i] = arr[i][j];
            }
        }
        backtracking(1);
        System.out.println(min);
        sc.close();
    }
}
