package Programmers_lev2.Zip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class zip {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution("KAKAO")));
        System.out.println(Arrays.toString(Solution.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(Solution.solution("ABABABABABABABAB")));
    }
}

class Solution {
    public static int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        int value = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(String.valueOf(ch), value++);
        }

        int idx = 0;
        while (idx < msg.length()) {
            StringBuilder w = new StringBuilder();
            w.append(msg.charAt(idx));

            while (dictionary.containsKey(w.toString()) && idx + w.length() < msg.length()) {
                w.append(msg.charAt(idx + w.length()));
            }

            if (dictionary.containsKey(w.toString())) {
                result.add(dictionary.get(w.toString()));
            } else {
                result.add(dictionary.get(w.substring(0, w.length() - 1)));
                dictionary.put(w.toString(), value++);
                idx--;
            }
            idx += w.length();
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}


//package Programmers_lev2.Zip;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class zip {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(Solution.solution("KAKAO")));
//        System.out.println(Arrays.toString(Solution.solution("TOBEORNOTTOBEORTOBEORNOT")));
//        System.out.println(Arrays.toString(Solution.solution("ABABABABABABABAB")));
//    }
//}
//
//class Solution {
//    public static int getKeyFromValue(HashMap<Integer, String> map, String value) {
//        for (int i : map.keySet()) {
//            if (map.get(i).equals(value)) {
//                return i;
//            }
//        }
//        return 0;
//    }
//    public static int[] solution(String msg) {
//        HashMap<Integer, String> map = new HashMap<>();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        int len = 27;
//        for (int i = 1; i < len; i++) {
//            map.put(i, Character.toString(('A' + i - 1)));
//        }
//
//        for (int i = 0; i < msg.length() - 1; i++) {
//            int idx = 1;
//            StringBuilder sb = new StringBuilder();
//            String str = sb.append(msg.charAt(i)).toString();
//
//            do {
//                str = sb.toString();
//                System.out.println(str);
//                sb.append(msg.charAt(i + idx++));
//
//            } while (map.containsValue(sb.toString()) && i + idx < msg.length());
//
//            map.put(len++,sb.toString());
//
//            if (i + idx >= msg.length()) {
//                list.add(getKeyFromValue(map, sb.toString()));
//            } else {
//                list.add(getKeyFromValue(map, str));
//            }
//
//            if (idx > 2) {
//                i += idx - 2;
//            }
//        }
//
//        System.out.println(map.toString());
//
//        return list.stream().mapToInt(i -> i.intValue()).toArray();
//    }
//}