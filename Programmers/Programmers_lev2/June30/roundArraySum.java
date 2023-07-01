package Programmers_lev2.June30;

import java.util.*;

public class roundArraySum {
    public static void main(String[] args) {
    
    }
}

class Solution630_2 {
    Set<Integer> set = new HashSet<Integer>();
    
    public void slidingWindow(int[] elements, int w) {
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + w; j++) {
                int tmp = j;
                if (tmp > elements.length - 1) {
                    tmp = j - elements.length;
                }
                sum += elements[tmp];
            }
            set.add(sum);
        }
    }

    public int solution(int[] elements) {
        for (int i = 1; i <= elements.length;i++) {
            slidingWindow(elements,i);   
        }
        return set.size();
    }
}

// import java.util.*;

// class Solution630_2 {
//     public int solution(int[] elements) {
//         int n = elements.length;
//         int[] extendedElements = new int[2 * n];
//         int[] prefixSum = new int[2 * n + 1];

//         // 원형 수열을 두 번 반복한 새로운 수열을 만듦
//         for (int i = 0; i < 2 * n; i++) {
//             extendedElements[i] = elements[i % n];
//         }

//         // 누적 합을 계산
//         for (int i = 1; i <= 2 * n; i++) {
//             prefixSum[i] = prefixSum[i - 1] + extendedElements[i - 1];
//         }

//         Set<Integer> sums = new HashSet<>();

//         // 각 연속 부분 수열에 대해 누적 합을 사용하여 부분 합을 계산
//         for (int i = 0; i < n; i++) {
//             for (int length = 1; length <= n; length++) {
//                 int sum = prefixSum[i + length] - prefixSum[i];
//                 sums.add(sum);
//             }
//         }

//         // HashSet의 크기를 반환
//         return sums.size();
//     }

//     public static void main(String[] args) {
//         Solution630_2 solution = new Solution630_2();
//         int[] elements = {7, 9, 1, 1, 4};
//         System.out.println(solution.solution(elements)); // Output: 18
//     }
// }
