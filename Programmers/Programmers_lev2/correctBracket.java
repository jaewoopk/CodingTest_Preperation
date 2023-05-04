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
        String[] str = s.split("");
        Stack<String> stack = new Stack<String>();
        
        for (String e : str) {
            if (e.equals("(")) stack.add("(");
            else if (e.equals(")") && stack.isEmpty()) return false;
            else if (e.equals(")") && stack.peek().equals("(")) stack.pop();
        }
        if (!stack.empty())
            return false;
        return true;
    }
}