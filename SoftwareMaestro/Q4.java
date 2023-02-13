package SoftwareMaestro;

import java.util.Scanner;

public class Q4 {
    static int n, t, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            count = 0;
            t = sc.nextInt();
            DFS(0);
            System.out.println(count);
        }
        sc.close();
    }
    static void DFS(int num) {
        if (num == t) {
            count++;
            return ;
        }

        for (int i = 1; i <= 3; i++) {
            if (num + i > t) {
                break ;
            }
            DFS(num + i);
        }
    }
}
