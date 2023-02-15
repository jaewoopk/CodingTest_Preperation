package SoftwareMaestro;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n + 4];

        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < n + 1; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }
        }
        System.out.println(arr[n]);
        sc.close();
    }
}
