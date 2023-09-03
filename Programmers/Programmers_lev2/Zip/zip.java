package Programmers_lev2.Zip;

import java.util.ArrayList;
import java.util.HashMap;

public class zip {
    public static void main(String[] args) {
        System.out.println(Solution.solution("KAKAO"));
    }
}

class Solution {
    public static int[] solution(String msg) {
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int len = 27;
        boolean[] visited = new boolean[10001];

        for (int i = 1; i < 27; i++) {
            map.put(i, Character.toString(('A' + i - 1)));
        }

        for (int i = 0; i < msg.length(); i++) {
            for (int j = 1; j < len; j++) {
                if (!visited[j] && map.get(j).equals(Character.toString(msg.charAt(i)))) {
                    visited[j] = true;
                    list.add(j);
                }
            }
        }

        System.out.println(map.toString());

        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }
}