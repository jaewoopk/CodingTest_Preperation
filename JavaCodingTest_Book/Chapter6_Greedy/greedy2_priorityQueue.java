package Chapter6_Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class greedy2_priorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            pq.add(data);
        }
        int data1 = 0;
        int data2 = 0;

        int sum = 0;

        while (pq.size() != 1) {
            data1 = pq.poll();
            data2 = pq.poll();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);

        sc.close();
    }
}
