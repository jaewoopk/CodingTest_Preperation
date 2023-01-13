package Chapter4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quickSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }
}

// public class quickSort { quickSort구현에 대해서 정리 한 번 더 할 것
//     static int[] arr = {42,32,24,60,15,5,90,45};
//     public static void qsort(int s, int e, int p) {
//         while (s < e) {
//             if (arr[s] < arr[p] && arr[e] > arr[p]) {
//                 s++;
//                 e--;
//             }
//             else if (arr[s] < arr[p] && arr[e] < arr[p]) {
//                 s++;
//             }
//             else if (arr[s] > arr[p] && arr[e] < arr[p]) {
//                 int tmp = arr[s];
//                 arr[s] = arr[e];
//                 arr[e] = tmp;
//                 s++;
//                 e--;
//             }
//             else if (arr[s] > arr[p] && arr[e] > arr[p]) {
//                 e--;
//             }
//         }
//         if (s > 1) {
//             qsort(0, s - 1, s);
//         }
//         if (e < 6) {
//             qsort(e,7, e - 1);
//         }
//     }
//     public static void main(String[] args) {
//         qsort(0, 6, 7);
//     }
// }
