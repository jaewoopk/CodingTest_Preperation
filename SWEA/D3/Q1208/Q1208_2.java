 wrong way
package SWEA.D3.Q1208;

import java.util.*;
import java.io.*;

public class Q1208_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 11; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> b - a);

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < 100; i++){
                minQ.add(arr[j]);
                maxQ.add(arr[j]);
            }

            for (int j = 0; j < n; j++) {
                minQ.add(minQ.poll() + 1);
                maxQ.add(maxQ.poll() - 1);
            }
            System.out.println("#" + i + " " + (maxQ.poll() - minQ.poll()));
        }
    }
}
