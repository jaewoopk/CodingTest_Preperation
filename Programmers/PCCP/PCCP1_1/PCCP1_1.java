package PCCP.PCCP1_1;

import java.util.*;

public class PCCP1_1 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("aaabbdeffeeca"));
    }
}

class Solution {
    public static String solution(String input_string) {
        char[] chArr = new char[26];
        char[] str = input_string.toCharArray();
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();

        visited[str[0] - 'a'] = true;

        for (int i = 1; i < str.length; i++) {
            int tmp = str[i] - 'a';
            if (str[i - 1] == str[i]) continue;
            if (!visited[tmp]) {
                visited[tmp] = true;
            } else {
                chArr[tmp]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            if (chArr[i] != 0) {
                sb.append(ch);
            }
        }
        String answer = sb.toString();
        if (answer.length() == 0) return "N";
        return answer;
    }
}
