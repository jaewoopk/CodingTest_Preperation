package Programmers_lev2.RollCake;

import java.util.*;
import java.util.stream.Collectors;

public class rollcake {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
    }
}

// 시간 초과
//class Solution {
//    public static int solution(int[] topping) {
//        int count = 0;
//        for (int i = 1; i < topping.length; i++) {
//            HashSet<Integer> A = new HashSet<>(Arrays.stream(Arrays.copyOfRange(topping,0,i)).boxed().collect(Collectors.toSet()));
//            HashSet<Integer> B = new HashSet<>(Arrays.stream(Arrays.copyOfRange(topping,i,topping.length)).boxed().collect(Collectors.toSet()));
//            if (A.size() == B.size()) {
//                count++;
//            }
//        }
//        return count;
//    }
//}

class Solution {
    public static int solution(int[] topping) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> cmpMap = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            map.computeIfAbsent(topping[i], k -> 0);
            map.put(topping[i], map.get(topping[i]) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            Integer a = map.getOrDefault(topping[i], null);
            if (a == null) {
                continue;
            }
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            cmpMap.computeIfAbsent(topping[i], k -> 0);
            cmpMap.put(topping[i], cmpMap.get(topping[i]) + 1);
            //System.out.println(map.size() + " " + cmpMap.size());
            if (map.size() == cmpMap.size()) {
                count++;
            }
        }
        return count;
    }
}