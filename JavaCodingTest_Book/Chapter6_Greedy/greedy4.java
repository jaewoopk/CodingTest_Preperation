package Chapter6_Greedy;

import java.io.*;
import java.util.*;

public class greedy4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if (S[1] == E[1]) {
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });

        // for (var e : arr) {
        //     System.out.println(e[0] + " " + e[1]);
        // }

        int count = 0;
        int end = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
