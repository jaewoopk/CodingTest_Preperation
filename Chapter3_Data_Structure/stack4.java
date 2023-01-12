package Chapter3_Data_Structure;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class stack4 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs) {
                return (o1 > o2 ? 1 : -1);
            }
            else {
                return (first_abs - second_abs);
            }
        });

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.add(num);
            }
        }
        sc.close();
    }
}
