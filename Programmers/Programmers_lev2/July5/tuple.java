package Programmers_lev2.July5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class tuple {
    public static void main(String[] args) {
        String s1 = "{{20,111},{111}}";
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        Solution705_1.solution(s1);
    }
}

class Solution705_1 {
    public static int[] solution(String s) {
        HashMap<Integer,Integer> hash = new HashMap<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '{' && arr[i] != '}' && arr[i] != ',') {
                int tmp = Character.getNumericValue(arr[i]);
                int size = 0;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    if (arr[j] >= '0' && arr[j] <= '9') {
                        tmp *= 10;
                        tmp += Character.getNumericValue(arr[j]);
                        size++;
                    }
                    else {
                        break ;
                    }
                }
                i += size;
                hash.put(tmp, hash.getOrDefault(tmp, 0) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries =
            hash.entrySet().stream()
                          .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                          .collect(Collectors.toList());

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            list.add(entry.getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}


// import java.util.*;
// import java.util.regex.*;

// public class TupleExtractor {

//     public static void main(String[] args) {
//         String s1 = "{{20,111},{111}}";
//         String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//         int[] result = solution(s1);
//         for (int num : result) {
//             System.out.print(num + " ");
//         }
//     }

//     public static int[] solution(String s) {
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         Matcher matcher = Pattern.compile("\\d+").matcher(s);

//         while (matcher.find()) {
//             int number = Integer.parseInt(matcher.group());
//             freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
//         }

//         return freqMap.entrySet().stream()
//                 .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
//                 .map(Map.Entry::getKey)
//                 .mapToInt(Integer::intValue)
//                 .toArray();
//     }
// }
