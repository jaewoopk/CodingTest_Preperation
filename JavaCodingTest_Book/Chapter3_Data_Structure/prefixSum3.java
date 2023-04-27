package Chapter3_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefixSum3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long cnt = 0;
        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];
        long[] div = new long[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        
        for (int i = 1; i < n + 1; i++) {
            sum[i] %= m;
            div[(int) (sum[i] + 1)]++;
        }

        cnt += div[1];

        for (int i = 1; i < m + 1; i++) {
            cnt += (div[i] * (div[i] - 1) / 2);
        }

        System.out.println(cnt);
    }
}


// public class prefixSum3 { // 첫번째 풀이
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         int cnt = 0;
//         int[][] sum = new int[n + 1][n + 1];
//         st = new StringTokenizer(br.readLine());
//         for (int i = 1; i < n + 1; i++) {
//             sum[1][i] = Integer.parseInt(st.nextToken());
//             if (sum[1][i] % m == 0) cnt++;
//         }
        
//         for (int i = 2; i < n + 1; i++) {
//             for (int j = 1; j < n + 2 - i; j++) {
//                 sum[i][j] = sum[i - 1][j] + sum[i - 1][j + 1] - sum[i - 2][j + 1];
//                 if (sum[i][j] % m == 0) cnt++;
//             }
//         }
//         System.out.println(cnt);
//     }
// }
