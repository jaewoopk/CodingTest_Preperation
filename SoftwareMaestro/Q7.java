package SoftwareMaestro;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (j == 1) {
                    arr[i][j] += arr[i - 1][j];
                }
                else if (j == i){
                    arr[i][j] += arr[i - 1][j - 1];
                }
                else {
                    arr[i][j] += (Math.max(arr[i - 1][j], arr[i - 1][j - 1]));
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (max < arr[n][i]) {
                max = arr[n][i];
            }
        }
        System.out.println(max);
        sc.close();
    }
}
