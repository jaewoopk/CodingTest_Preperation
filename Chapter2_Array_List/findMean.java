package Chapter2_Data_Structure;

import java.util.Scanner;

public class findMean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];
        int max = Integer.MIN_VALUE;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) max = arr[i];
        }
        
        for (int i = 0; i < n; i++) {
            sum += ((double)arr[i] / max) * 100;
        }
        System.out.println(sum / n);
        sc.close();
    }
}
