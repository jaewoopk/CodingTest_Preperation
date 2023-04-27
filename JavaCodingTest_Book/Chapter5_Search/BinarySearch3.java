package Chapter5_Search;

import java.util.Scanner;

public class BinarySearch3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long start = 1, end = k;
        long ans = 0;
        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i < n + 1; i++) {
                cnt += Math.min(middle / i, n);
            }
            if (cnt < k) {
                start = middle + 1;
            }
            else {
                ans = middle;
                end = middle - 1;
            }
        }
        
        System.out.println(ans);
        sc.close();
    }
}

// public class BinarySearch3 { // 문제에서 이진탐색의 생각이 나지를 않는다.
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int k = sc.nextInt();
        
//         if (n <= 1000) {
//             int[] arr = new int[n * n + 1];
//             for (int i = 1; i < n + 1; i++) {
//                 for (int j = 1; j < n + 1; j++) {
//                     arr[(n * (i - 1)) + j] = i * j;
//                 }
//             }
//             Arrays.sort(arr);
//             System.out.println(arr[k]);
//         }
//         else {
//             int x = (k % n == 0) ? k / n : k / n + 1;
//             int y = (k % n == 0) ? k % n + n : k % n;
//             System.out.println(x + " " + y);
//         }
//         sc.close();
//     }
// }
