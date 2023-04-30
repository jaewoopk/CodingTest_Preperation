package Programmers_lev2;

public class Jadencase extends Solution{
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
}

// Jadencase 문제에 대한 로직
// 나의 풀이
// 1. 띄어쓰기 다음의 upperCase의 경우에는 ch에 lowerCase를 적용하여 answer에 더하기
// 
// 다른 풀이
// 1. 먼저 부여 받은 String s에 Lowercase를 적용하여 String[] 배열에 split 한다.
// 2. flag를 통해 true일 경우 대문자화하여 더하고, 그렇지 않으면 그냥 더한다.
// 3. flag를 e.equals(" ")를 통해 띄어쓰기와 대조하고, 띄어쓰기 일경우 true, 아닐 경우 false를 반환한다.

class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split("");
        boolean flag = true;

        for (String e : str) {
            answer += flag ? e.toUpperCase() : e;
            flag = e.equals(" ") ? true : false;
        }
        return answer;
    }
}

// class Solution {
//     public static String solution(String s) {
//         String answer = "";
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if ((i == 0)) {
//                 if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
//                     ch = (char) (s.charAt(i) - 32);
//             }
//             else {
//                 if ((s.charAt(i - 1) == ' ') && (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
//                     ch = (char) (s.charAt(i) - 32);
//                 }
//                 else if (s.charAt(i - 1) != ' ' && ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))) {
//                     ch = (char) (s.charAt(i) + 32);
//                 }
//             }
//             answer += ch;
//         }
//         return answer;
//     }
// }