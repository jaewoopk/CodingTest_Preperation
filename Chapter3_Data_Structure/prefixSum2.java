package Chapter3_prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefixSum2 {
    public static void main(String[] args) throws IOException{
        // 정답
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            System.out.println(answer);
        }
    }
}


// public class prefixSum2 {
//     public static void main(String[] args) throws IOException{

//         // 시간 초과 -> 결국 이 방법도 이중 반복문을 쓰는 것. 더 똑똑하고 간결하게 생각해야함
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(bf.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         int[] sum = new int[n * n + 1];

//         for (int i = 1; i < n + 1; i++) {
//             st = new StringTokenizer(bf.readLine());
//             for (int j = 1; j < n + 1; j++) {
//                 sum[(i - 1) * n + j] = sum[(i - 1) * n + j - 1] + Integer.parseInt(st.nextToken());
//             }
//         }

//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(bf.readLine());
//             int s1,s2;
//             int e1,e2;
//             int answer = 0;
//             s1 = Integer.parseInt(st.nextToken());
//             s2 = Integer.parseInt(st.nextToken());
//             e1 = Integer.parseInt(st.nextToken());
//             e2 = Integer.parseInt(st.nextToken());

//             for (int j = s1; j <= e1; j++) {
//                 answer += (sum[((j - 1) * n + e2)] - sum[(j - 1) * n + (s2 - 1)]);
//             }
//             System.out.println(answer);
//         }
//     }
// }
