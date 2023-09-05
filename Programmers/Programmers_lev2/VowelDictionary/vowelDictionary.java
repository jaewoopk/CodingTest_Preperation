package Programmers_lev2.VowelDictionary;

public class vowelDictionary {
    public static void main(String[] args) {
        System.out.println(Solution.solution("AAAAE"));
        System.out.println(Solution.solution("EIO"));
    }
}

class Solution {
    static int idx = 1;
    static String[] dic;
    static Character[] str;
    public static void dfs(int len) {
        if (len >= 5) return;
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0 -> str[len] = 'A';
                case 1 -> str[len] = 'A';
                case 2 -> str[len] = 'A';
                case 3 -> str[len] = 'A';
                case 4 -> str[len] = 'A';
            }
            System.out.println(str);
            dic[idx++] = str;
            dfs(new String(str), len + 1);
        }

    }
    public static int solution(String word) {
        dic = new String[3906];
        str = new Character[5];
        dfs(new String(), 0);

        int answer = 0;
        return answer;
    }
}