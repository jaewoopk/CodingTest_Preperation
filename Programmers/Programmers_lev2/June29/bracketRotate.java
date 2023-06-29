package Programmers_lev2.June29;

import java.util.*;

public class bracketRotate {
    public static void main(String[] args) {
        String str = "[](){}";
        System.out.println(Solution629_1.solution(str));
    }    
}

class Solution629_1 {
    public static boolean isCorrect(Deque<Character> str) {
        Stack<Character> stack = new Stack<Character>();
        for (char e : str) {
            if (e == '[' || e == '(' || e == '{') stack.add(e);
            else if (!stack.isEmpty()
                && ((stack.peek() == '[' && e == ']')
                || (stack.peek() == '(' && e == ')')
                || (stack.peek() == '{' && e == '}'))) {
                    stack.pop();
            }
            else {
                stack.add(e);
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
    public static int solution(String s) {
        int answer = 0;
        Deque<Character> dq = new ArrayDeque<Character>();
        
        for (char e : s.toCharArray()) {
            dq.add(e);
        }

        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(dq)) {
                answer++;
            }
            dq.addLast(dq.peekFirst());
            dq.pop();
        }
        
        return answer;
    }
}