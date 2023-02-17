package SoftwareMaestro;

import java.util.*;
import java.io.*;

public class Q12 {
    static int n, k;
    static Integer[] arr;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = 0;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }
        });

        myGreedy(0, 0);
        System.out.println(count);

    }
 
    static void myGreedy(int sum, int idx) {
        if (sum == k) {
            count++;
            return ;
        }
        else if (sum > k) {
            return ;
        }
        for (int i = idx; i < n; i++) {
            myGreedy(sum + arr[i], idx + 1);
        }
    }
}
