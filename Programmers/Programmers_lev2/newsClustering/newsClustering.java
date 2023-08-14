package Programmers_lev2.newsClustering;

import java.util.*;

public class newsClustering {
    public static void main(String[] args) {
        System.out.println(Solution.solution("handshake","shake hands"));
    }
}

class Solution {
    public static String makeTwoLengthWord(String word, int i) {
        StringBuilder sb = new StringBuilder();
        if (word.charAt(i) < 'a' || word.charAt(i) > 'z' ||
            word.charAt(i + 1) < 'a' || word.charAt(i + 1) > 'z') {
            return null;
        }
        sb.append(word.charAt(i));
        sb.append(word.charAt(i + 1));
        return sb.toString();
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        String word1 = str1.toLowerCase();
        String word2 = str2.toLowerCase();

        //System.out.println(word1 + " " + word2);

        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        LinkedList<String> gList = new LinkedList<>();
        LinkedList<String> hList = new LinkedList<>();

        for (int i = 0; i < word1.length() - 1; i++) {
            if (makeTwoLengthWord(word1, i) == null) {
                continue;
            }
            list1.add(makeTwoLengthWord(word1, i));
        }
        for (int i = 0; i < word2.length() - 1; i++) {
            if (makeTwoLengthWord(word2, i) == null) {
                continue;
            }
            list2.add(makeTwoLengthWord(word2, i));
        }

        int listLen1 = list1.size();

        for (int i = 0; i < listLen1; i++) {
            boolean findWord = false;
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    gList.add(list1.get(i));
                    hList.add(list1.get(i));
                    list2.remove(j);
                    findWord = true;
                    break;
                }
            }
            if (!findWord) {
                hList.add(list1.get(i));
            }
        }

        while (!list2.isEmpty()) {
            hList.add(list2.pop());
        }

        return (hList.size() == 0 && gList.size() == 0) ? 65536 : (int)(65536 * ((double)gList.size() / (double)hList.size()));
    }
}
