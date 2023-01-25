package Chapter5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, start, end;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = 0;
        end = 0;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i]) {
                start = arr[i];
            }
            end += arr[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > middle) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                cnt++;
            }
            if (cnt > m) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}

// public class BinarySearch2 { // 이진탐색 응용이 생각보다 어려운 듯
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n, m, sum;
//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         sum = 0;
//         int[] arr = new int[n];
//         int[] answer = new int[m];
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//             sum += arr[i];
//         }
//         int target = sum / m;

//         int idx = 0;
//         for (int i = 0; i < n; i++) {
//             if (answer[idx] >= target) {
//                 idx++;
//             }
//             else if (target - answer[idx] < answer[idx] + arr[i] - target){
//                 idx++;
//             }
//             answer[idx] += arr[i];
//         }
//         int max = 0;
//         for (var e : answer) {
//             max = Math.max(max, e);
//         }
//         System.out.println(max);
//     }
// }
