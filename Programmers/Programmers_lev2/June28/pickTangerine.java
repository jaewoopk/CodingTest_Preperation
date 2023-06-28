package Programmers_lev2.June28;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class pickTangerine {
    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4,5,2,3};

        System.out.println(Solution628_2.solution(6, arr));
    }
}

class Solution628_2 {
    public static int solution(int k, int[] tangerine) {
        int count = 0;
        int maxValue = Arrays.stream(tangerine).max().getAsInt();
        int[] arr = new int[maxValue + 1];

        for (int e : tangerine) {
            arr[e]++;
        }
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        Arrays.sort(array, Collections.reverseOrder());
        while (k > 0) {
            k -= array[count];
            count++;
        }
        return count;
    }
}

// class Solution628_2 {
//     public static int solution(int k, int[] tangerine) {
//         int count = 0;
//         List<Integer> list = Arrays.stream(tangerine).boxed().collect(Collectors.toList());
//         List<Integer> set = list.stream().distinct().collect(Collectors.toList());
        
//         while (!list.isEmpty()) {
//             for (Integer e : set) {
//                 if (list.contains(e)) {
//                     list.remove(e);
//                 }
//             }
//             count++;
//         }
//         if (count == 0) {
//             return 1;
//         }
//         return k / count;
//     }
// }

// import java.util.HashMap;

// public class SimpleSolution {
//     public static int solution(int k, int[] tangerine) {
//         HashMap<Integer, Integer> windowCounts = new HashMap<>();
//         int uniqueCount = 0, minUniqueCount = Integer.MAX_VALUE;

//         for (int i = 0; i < tangerine.length; i++) {
//             windowCounts.put(tangerine[i], windowCounts.getOrDefault(tangerine[i], 0) + 1);
//             if (windowCounts.get(tangerine[i]) == 1) uniqueCount++;

//             if (i >= k) {
//                 int left = tangerine[i - k];
//                 windowCounts.put(left, windowCounts.get(left) - 1);
//                 if (windowCounts.get(left) == 0) uniqueCount--;
//             }

//             if (i >= k - 1) minUniqueCount = Math.min(minUniqueCount, uniqueCount);
//         }

//         return minUniqueCount;
//     }

//     public static void main(String[] args) {
//         System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
//         System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
//         System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
//     }
// }