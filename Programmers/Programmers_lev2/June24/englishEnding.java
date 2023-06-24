package Programmers_lev2.June24;

import java.util.LinkedList;

public class englishEnding {
    public static void main(String[] args) {
        String[] str = {"dank","oick","know","wheel","land","dream","mother","robot","ank"};
        System.out.println(Solution624_1.solution(3, str)[0]);
        System.out.println(Solution624_1.solution(3, str)[1]);
    }
}

class Solution624_1 {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int idx = 0;
        boolean check = false;
        LinkedList<String> findBefore = new LinkedList<String>();
        while (idx < words.length) {
            for (int i = 0; i < n; i++) {
                for (String e : findBefore) {
                    if (e.equals(words[idx + i]) || check) {
                        answer[0] = i + 1;
                        answer[1] = (int)(idx / n) + 1;
                        return answer;
                    }
                }
                if (idx + i + 1 < words.length && (words[idx + i].charAt(words[idx + i].length() - 1)
                == words[idx + i + 1].charAt(0))) {
                    findBefore.add(words[idx + i]);
                    continue ;
                }
                else if (idx + i + 1 == words.length &&
                (words[words.length - 1].charAt(0) != words[words.length - 2].charAt(words[words.length -2].length() - 1))){
                    answer[0] = i + 1;
                    answer[1] = (int)(idx / n) + 1;
                    return answer;
                }
                else if (idx + i + 1 == words.length) {
                    return answer;
                }
                else {
                    findBefore.add(words[idx + i]);
                    check = true;
                }
            }
            idx += n;
        }
        return answer;
    }
}