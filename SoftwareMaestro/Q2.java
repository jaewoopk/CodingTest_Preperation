package SoftwareMaestro;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[301];
        int[] answer = new int[301];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer[1] = arr[1];
        answer[2] = arr[1] + arr[2];
        for (int i = 3; i < n + 1; i++) {
            answer[i] = Math.max(answer[i - 2], answer[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(answer[n]);
        
    }
}
