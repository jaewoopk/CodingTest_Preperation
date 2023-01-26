package Chapter6_Greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class greedy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            if (data > 0) {
                pq1.add(data);
            }
            else {
                pq2.add(data);
            }
        }

        while (!pq1.isEmpty()) {
            int data1 = pq1.poll();
            if (pq1.isEmpty()) {
                answer += data1;
                break ;
            }
            int data2 = pq1.poll();
            if (data1 > 1 && data2 > 1) {
                answer += (data1 * data2);
            }
            else {
                answer += (data1 + data2);
            }
        }

        while (!pq2.isEmpty()) {
            int data1 = pq2.poll();
            if (pq2.isEmpty()) {
                answer += data1;
                break ;
            }
            int data2 = pq2.poll();
            if (data1 <= 0 && data2 <= 0) {
                answer += (data1 * data2);
            }
            else {
                answer += (data1 + data2);
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
