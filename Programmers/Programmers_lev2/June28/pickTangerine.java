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