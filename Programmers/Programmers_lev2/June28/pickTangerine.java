package Programmers_lev2.June28;

import java.util.Arrays;
import java.util.Collections;
// import java.util.List;
// import java.util.stream.Collectors;

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

// class Solution {
//     public int solution(int k, int[] tangerine) {
//         int answer = 0;
//         HashMap<Integer,Integer> map =new HashMap<>();

//         for (int t : tangerine) {
//             map.put(t, map.getOrDefault(t, 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>(map.keySet());
//         list.sort((o1, o2) -> map.get(o2)-map.get(o1));

//         for(Integer key:list){
//             k -=map.get(key);
//             answer++;
//             if(k<=0){
//                 break;
//             }
//         }

//         return answer;
//     }
// }