package Chapter2_Data_Structure;

import java.util.Scanner;

public class prefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 0; i < m; i++) {
            int start, end;
            start = sc.nextInt();
            end = sc.nextInt();
            System.out.println(sum[end] - sum[start - 1]);
        }
        sc.close();
    }
}
