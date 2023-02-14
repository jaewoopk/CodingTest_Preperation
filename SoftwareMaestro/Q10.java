package SoftwareMaestro;

import java.util.*;
import java.io.*;

public class Q10 {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[100002];
        
        for (int i = 0; i < 100002; i++) {
            arr[i] = -1;
        }
        arr[n] = 0;
        q.add(n);
           
        while (arr[m] == -1) {
            int cur = q.poll();
            
            int[] check = {cur - 1, cur + 1, cur * 2};
            
            for (int next : check) {
                if (next < 0 || next > 100000) {
                    continue ;
                }
                if (arr[next] != -1) {
                    continue ;
                }
                arr[next] = arr[cur] + 1;
                q.add(next);
            }
        }
        System.out.println(arr[m]);
    }
}