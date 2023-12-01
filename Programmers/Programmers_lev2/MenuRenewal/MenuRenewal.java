package Programmers_lev2.MenuRenewal;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {

    }
}

class Solution {
    static HashMap<String, Integer> map;
    static String[] str;
    static void dfs(int idx, String word) {
        if (idx == str.length) {
            return;
        }
        for (int i = idx + 1; i < str.length; i++) {
            dfs(idx + 1, word + str[i]);
        }
    }
    public static String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();

        for (String e : orders) {
            str = e.split("");
            dfs(0, " ");

        }
        return str;
    }
}
