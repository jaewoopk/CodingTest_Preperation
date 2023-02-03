package Chapter7_Number_Theory;

import java.util.*;
import java.io.*;

public class GCD4 {
    static ArrayList<cNode>[] arr;
    static long lcm;
    static boolean[] visited;
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        D = new long[n];
        lcm = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<cNode>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a, b, p, q;
            a = sc.nextInt();
            b = sc.nextInt();
            p = sc.nextInt();
            q = sc.nextInt();
            arr[a].add(new cNode(b, p, q));
            arr[b].add(new cNode(a, q, p));
            lcm *= lcm4(p, q, gcd4(p, q));
        }
        D[0] = lcm;
        DFS(0);

        long mgcd = D[0];

        for (int i = 1; i < n; i++) {
            mgcd = gcd4(mgcd, D[i]);
        }

        for (var e : D) {
            bw.write(String.valueOf(e / mgcd) + " ");
        }


        bw.flush();
        bw.close();
        sc.close();
    }

    static long gcd4(long a, long b) {
        if (a == 0) {
            return b;
        }
        else {
            return gcd4(b % a, a);
        }
    }

    static long lcm4(long a, long b, long gcd) {
        return a * b / gcd;
    }

    static void DFS(int node) {
        visited[node] = true;

        for (cNode e : arr[node]) {
            int next = e.getB();
            if (!visited[next]) {
                D[next] = D[node] * e.getQ() / e.getP();
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;
    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return this.b;
    }
    public int getP() {
        return this.p;
    }
    public int getQ() {
        return this.q;
    }
}

// public class GCD4 { // 최소 공배수와 최대 공약수를 통해 푸는 것은 맞지만, 응용이 너무 어렵다. 답과 비교하고 무엇이 부족했는지 계속 생각해보자
//     public static void main(String[] args) throws IOException {
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();

//         int[] arr = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = 1;
//         }

//         for (int i = 0; i < n - 1; i++) {
//             int a, b, p, q;
//             a = sc.nextInt();
//             b = sc.nextInt();
//             p = sc.nextInt();
//             q = sc.nextInt();

//             int tmpp = p;
//             int tmpq = q;
//             int gcdValue = gcd4(Math.min(tmpp, tmpq), Math.max(tmpp, tmpq));
//             p /= gcdValue;
//             q /= gcdValue;
            
//             arr[a] *= (p * gcdValue);
//             arr[b] *= (q * gcdValue);
//         }

//         for (var e : arr) {
//             bw.write(String.valueOf(e) + " ");
//         }
//         System.out.println();
//         bw.flush();
//         bw.close();
//         sc.close();
//     }

//     static int gcd4(int a, int b) {
//         if (a == 0) {
//             return b;
//         }
//         else {
//             return gcd4(b % a, a);
//         }
//     }

//     static int lcm(int a, int b, int gcd) {
//         return a * b / gcd;
//     }
// }
