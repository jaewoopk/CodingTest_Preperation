package Programmers_lev2.July4;

import java.util.ArrayList;
import java.util.HashMap;

public class clothes {
    public static void main(String[] args) {
        String[][] t = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(Solution704_1.solution(t));

    }
}

class Solution704_1 {
    static boolean[] visited;
    static ArrayList<Integer> arr;
    static int answer;
    public static void dfs(int idx, int end, int val) {
        if (idx == end) {
            answer += val;
        }
        for (int i = idx; i < arr.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, end, val * arr.get(i));
                visited[i] = false;
            }
        }
    }
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        for (String[] cloth : clothes) {
            if (!hash.containsKey(cloth[1])) {
                hash.put(cloth[1], 1);
            }
            else {
                int tmp = hash.get(cloth[1]);
                hash.replace(cloth[1], tmp + 1);
            }
        }
        arr = new ArrayList<Integer>();
        visited = new boolean[hash.size()];
        
        for (Integer e : hash.values()) {
            arr.add(e);
        }   

        for (int i = 1; i <= arr.size(); i++) {
            dfs(0, i, 1);
        }
        return answer;
    }
}

    // public static int combination(int val, int end, int idx, int[] arr) {
    //     if (end == idx) {
    //         return val;
    //     }
    //     int value = 1;
    //     int tmp = 0;
    //     for (int i = idx; i < arr.length; i++) {
    //         value = combination(val * arr[i], end, idx + 1, arr);
    //         tmp += value;
    //     }
    //     return tmp;
    // }
    // public static int getAnswer(int[] arr) {
    //     int answer = 0;
    //     for (int i = 1; i <= arr.length; i++) {
    //         answer += combination(1, i, 0, arr);
    //     }
    //     return answer;
    // }

// import java.util.HashMap;

// public class Clothes {
//     public static void main(String[] args) {
//         String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//         System.out.println(solution(clothes));
//     }

//     public static int solution(String[][] clothes) {
//         HashMap<String, Integer> map = new HashMap<>();

//         for (String[] cloth : clothes) {
//             map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
//         }

//         int answer = 1;
//         for (int value : map.values()) {
//             answer *= (value + 1); // 각 의상 종류마다 착용하지 않는 경우를 고려하여 1을 더해준다.
//         }

//         return answer - 1; // 아무것도 착용하지 않는 경우를 제외하기 위해 1을 빼준다.
//     }
// }