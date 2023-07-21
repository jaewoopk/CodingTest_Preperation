package Programmers_lev2.discount_July21;

import java.util.*;

public class discount {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < discount.length - 9; i++) {
            boolean isRight = true;
            int len = 0;
            for (int j = 0; j < number.length; j++) {
                len += number[j];
                map.put(want[j], number[j]);
            }
            for (int j = i; j < i + len; j++) {
                if (map.containsKey(discount[j])) {
                    map.replace(discount[j], map.get(discount[j]) - 1);
                } else {
                    break;
                }
            }

            for (String e : map.keySet()) {
                if (map.get(e) != 0) {
                    isRight = false;
                    break;
                }
            }
            if (isRight) {
                answer++;
            }
        }
        return answer;
    }
}

//package Programmers_lev2.discount_July21;
//
//        import java.util.*;
//
//public class discount {
//    public static void main(String[] args) {
//    }
//}
//
//class Solution {
//    public static int solution(String[] want, int[] number, String[] discount) {
//        int answer = 0;
//
//        HashMap<String, Integer> map = new HashMap<>();
//        int len = 0;
//
//        for (int j = 0; j < number.length; j++) {
//            map.put(want[j], number[j]);
//            len += number[j];
//        }
//
//        for (int i = 0; i < discount.length - len + 1; i++) {
//            HashMap<String, Integer> tempMap = new HashMap<>(map);
//            boolean isRight = true;
//
//            for (int j = i; j < i + len; j++) {
//                if (tempMap.containsKey(discount[j]) && tempMap.get(discount[j]) > 0) {
//                    tempMap.replace(discount[j], tempMap.get(discount[j]) - 1);
//                }
//                else {
//                    isRight = false;
//                    break ;
//                }
//            }
//
//            if (isRight) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}
