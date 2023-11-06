package Baekjoon.Q3986;

import java.util.*;
import java.io.*;

public class Q3986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            Queue<Character> q = new LinkedList<>();

            for (char e : str) {
                q.add(e);
            }
            stack.push(q.poll());
            while (!q.isEmpty()) {
                char ch = q.poll();

                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
