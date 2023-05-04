package Programmers_lev2;

import java.util.Stack;

public class correctBracket extends Solution5{
    public static void main(String[] args) {
        System.out.println(solution5("()()"));
        System.out.println(solution5("()())"));
    }
}

class Solution5 {
    public static boolean solution5(String s) {
        if (s.length() % 2 == 1 || s.charAt(0) == ')') return false;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.add('(');
            else if ((s.charAt(i) == ')') && stack.isEmpty()) return false;
            else if ((s.charAt(i) == ')') && stack.peek().equals('(')) stack.pop();
        }
        if (!stack.empty())
            return false;
        return true;
    }
}