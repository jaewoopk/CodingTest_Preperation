package SWEA.D4.Q4408;

import java.util.*;
import java.io.*;

public class Q4408 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] map = new int[201];
            for (int k = 0; k < n; k++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = arr[0]; j < arr[1] + 1; j += 2) {
                    map[(int)((j - 0.5 )/ 2)] += 1;
                }
                for (int j = arr[0]; j > arr[1] - 1; j -= 2) {
                    map[(int)((j - 0.5 )/ 2)] += 1;
                }
            }
            Arrays.sort(map);
            System.out.println("#" + i + " " + map[200]);
        }
    }
}
