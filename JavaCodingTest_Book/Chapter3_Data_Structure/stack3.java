package Chapter3_Data_Structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class stack3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt();
        boolean checker = true;

        for (int i = n; i > 0; i--) {
            deque.add(i);
        }
        while(deque.size() != 1) {
            if (checker) {
                deque.removeLast();
                checker = false;
            }
            else {
                deque.addFirst(deque.peekLast());
                deque.removeLast();
                checker = true;
            }
        }

        System.out.println(deque.peek());

        sc.close();
    }
}
