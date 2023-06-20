package Chapter5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS2 {
    static Stack<Integer> firstStack;
    static int n;

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void dfs2(int idx, int num) {
        if (idx >= n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return ;
        }
        for (int i = 1; i < 10; i += 2) {
            if (!isPrime(num)) {
                return ;
            }

            // dfs2(idx + 1, num * 10 + i);
        }
    }
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(12);
        arr.add(13);
        System.out.println(arr.get(1));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        firstStack = new Stack<>();

        firstStack.add(7);
        firstStack.add(5);
        firstStack.add(3);
        firstStack.add(2);
        
        for (int i = 0; i < 4; i++) {
            dfs2(1, firstStack.pop());
        }
    }    
}
