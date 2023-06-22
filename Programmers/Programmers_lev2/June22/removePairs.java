package Programmers_lev2.June22;

import java.util.Stack;

public class removePairs {
    public static void main(String[] args) {
        System.out.println(Solution622_2.solution("baabaa"));
        System.out.println(Solution622_2.solution("cdcd"));
    }
}

class Solution622_2 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if (!stack.isEmpty()) {
                Character tmp = stack.peek();
                if (tmp == s.charAt(i)) {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}


// class Solution
// {
//     public int solution(String s)
//     {
//         int answer = 0;
//         Stack<Character> stack = new Stack<>();

//         for(char c : s.toCharArray()){
//             if(stack.size() == 0){
//                 stack.push(c);
//             }
//             else if(stack.peek() == c){
//                 stack.pop();
//             }
//             else{
//                 stack.push(c);
//             }
//         }


//         return stack.size() > 0 ? 0 : 1;
//     }
// }
// String을 charArray로 바꾸는 방법이 있다. s.toCharArray()를 통해 쉽게 접근할 수 있다.

// class Solution622_2 {
//     public static int solution(String s) {
//         String[] stringSplit = s.split("");
//         Stack<String> stack = new Stack<String>();
//         stack.push(stringSplit[0]);
//         for (int i = 1; i < stringSplit.length; i++){
//             if (!stack.isEmpty()) {
//                 String tmp = stack.peek();
//                 if (tmp.equals(stringSplit[i])) {
//                     stack.pop();
//                 }
//                 else {
//                     stack.push(stringSplit[i]);
//                 }
//             }
//             else {
//                 stack.push(stringSplit[i]);
//             }
//         }
//         if (stack.isEmpty()) {
//             return 1;
//         }
//         else {
//             return 0;
//         }
//     }
// }
