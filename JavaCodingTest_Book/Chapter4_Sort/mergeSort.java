package Chapter4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mergeSort {
    static int n;
    static int k;
    static int[] arr;
    static int[] newArr;
    static int count;

    public static void divideConquer(int s, int m, int e) {
        int idx = 0, i = s, j = m + 1;
        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                newArr[idx++] = arr[i++];
            }
            else {
                newArr[idx++] = arr[j++];
            }
        }
        while (i <= m) {
            newArr[idx++] = arr[i++];
        }
        while (j <= e) {
            newArr[idx++] = arr[j++];
        }
        idx = 0;
        for (int o = s; o <= e; o++) {
            arr[o] = newArr[idx++];
            count++;
            if (count == k) {
                System.out.println(arr[o]);
                System.exit(0);
            }
        }
    }

    public static void merge(int s, int e) {
        if (s < e) {
            int mid = ((s + e) / 2);
            merge(s, mid);
            merge(mid + 1, e);
            divideConquer(s, mid, e);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        newArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge(0, n - 1);
        System.out.println(-1);
    }
}
