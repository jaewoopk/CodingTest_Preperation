package Programmers_lev2.VowelDictionary;

import java.util.Arrays;

public class vowelDictionary {
    public static void main(String[] args) {
        System.out.println(Solution.solution("I"));
    }
}

class Solution {
    static int idx = 0;
    static Character[][] dic;
    static Character[] str;

    public static void dfs(int len) {
        if (len >= 5) return;
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0 -> str[len] = 'A';
                case 1 -> str[len] = 'E';
                case 2 -> str[len] = 'I';
                case 3 -> str[len] = 'O';
                case 4 -> str[len] = 'U';
            }
            dic[idx++] = str.clone();
            dfs(len + 1);
            str[len] = ' ';
        }

    }
    public static int solution(String word) {
        while (word.length() < 5) {
            word += " ";
        }

        char[] answer = new char[5];
        str = new Character[5];
        dic = new Character[3906][5];

        //init
        for (int i = 0; i < 5; i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                answer[i] = word.charAt(i);
            } else {
                answer[i] = ' ';
            }
            str[i] = ' ';
        }

        dfs(0);

        for (int i = 0; i < 3906; i++) {
            if (Arrays.toString(dic[i]).equals(Arrays.toString(answer))) {
                return i + 1;
            }
        }
        return 0;
    }
}