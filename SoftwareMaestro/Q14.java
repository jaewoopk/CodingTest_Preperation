package SoftwareMaestro;

import java.util.*;
import java.io.*;

public class Q14 {
    private static int n, m;
    private static int[] arr;
    private static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[10];
        check = new boolean[10];

        backTracking(1);
    }

    static void backTracking(int idx) {
        if (idx == m + 1) {
            for (int i = 1; i < m + 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[idx] = i;
                backTracking(idx + 1);
                check[i] = false;
            }
        }
    }
}
