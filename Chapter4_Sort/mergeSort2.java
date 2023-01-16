package Chapter4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mergeSort2 {
    static int n;
    static int[] arr;
    static int[] tmp;
    static long count;

    static void divideConquer_2(int s, int m, int e) {
        int idx = 0;
        int i = s, j = m + 1;
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                tmp[idx++] = arr[i++];
            }
            else {
                count = count + j - (s + idx);
                tmp[idx++] = arr[j++];
            }
        }
        
        while (i <= m) {
            tmp[idx++] = arr[i++];
        }

        while (j <= e) {
            tmp[idx++] = arr[j++];
        }

        idx = 0;
        for (int x = s; x <= e; x++) {
            arr[x] = tmp[idx++];
        }
    }

    static void merge_2(int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;
            merge_2(s, m);
            merge_2(m + 1, e);
            divideConquer_2(s, m, e);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_2(0, n - 1);

        System.out.println(count);
    }
}
