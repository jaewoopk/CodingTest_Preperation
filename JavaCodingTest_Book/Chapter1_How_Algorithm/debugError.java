package Chapter1_How_Algorithm;

import java.util.Scanner;

public class debugError {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int answer = 0;
        int A[] = new int[100001];
        int S[] = new int[100001];
        // 4. A and S are initialized with int, so that makes overflow -> should be initialized by long
        for (int i = 1; i < 1000; i++) {
            // 2. i is less than 1000, so S[1001] ~ S[100000] will be 0
            A[i] = (int) (Math.random() * Integer.MAX_VALUE);
            S[i] = S[i - 1] + A[i];
        }
        for (int t = 1; t < testcase; t++) {
            // 1. when t increase -> variable answer value should be initialized
            int query = sc.nextInt();
            for (int i = 0; i < query; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                answer += S[end] - S[start - 1];
                // 3. variable testcase will be t -> because of that should be find it's order
                System.out.println(testcase + " " + answer);
            }
        }
        sc.close();
    }
}
