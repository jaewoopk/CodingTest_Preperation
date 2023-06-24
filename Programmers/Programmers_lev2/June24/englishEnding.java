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

// import java.util.HashSet;
// import java.util.Set;

// public class EnglishWordChain {
// 	public static void main(String[] args) {
// 	    String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
// 	    String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
// 	    String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
	
// 	    System.out.println(solution(3, words1)[0] + " " + solution(3, words1)[1]);
// 	    System.out.println(solution(5, words2)[0] + " " + solution(5, words2)[1]);
// 	    System.out.println(solution(2, words3)[0] + " " + solution(2, words3)[1]);
// 	}
// }
// public static int[] solution(int n, String[] words) {
//     Set<String> usedWords = new HashSet<>();
//     usedWords.add(words[0]);

//     for (int i = 1; i < words.length; i++) {
//         if (usedWords.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
//             return new int[]{(i % n) + 1, (i / n) + 1};
//         }
//         usedWords.add(words[i]);
//     }

//     return new int[]{0, 0};
// }
// HashSet을 이용해 중복 처리 및 words[i].charAt()을 통해 String을 파싱합니다.
// if 문에 바로 return을 걸어 if문에 걸리지 않을 경우 int[]{0,0}을 리턴합니다.