package SWEA.D3.Q6190;

import java.util.*;
import java.io.*;
public class Q6190 {
    public static boolean isDanzo(int x) {
        char[] str = Integer.toString(x).toCharArray();
        for (int i = str.length - 1; i > 0; i--) {
            if (str[i - 1] > str[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = -1;
            Arrays.sort(arr);
            for (int j = arr.length - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int x = arr[j] * arr[k];
                    if (isDanzo(x)) {
                        max = Math.max(max, x);
                    }
                }

            }
            System.out.println("#" + i + " " + max);
        }
    }
}
