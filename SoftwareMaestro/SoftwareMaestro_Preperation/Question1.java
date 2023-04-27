package Programmers_Question;

public class Question1 extends Solution{
    public static void main(String[] args) {
        int n, m;
        n = 8;
        m = 4;
        int[] section = {2,3,6};
        System.out.println(solution(n,m,section));
    }
}


// 알고리즘이 주어지지 않은 상태에서 어떻게 풀 지에 대한 생각이 어렵다.
// 더 많이 풀어보면서 체득해야할 것 같다.
// class Solution {
//     public static int solution(int n, int m, int[] section) {
//         int answer = 0;
//         int firstNum = section[0];
//         int idx = 0;

//         for (int i = firstNum; i < n; i++) {
//             if (section[idx] >= i) {
//                 answer++;
//                 idx++;
//                 i = i + m - 1;
//             }
//             else {
//                 idx++;
//             }
//             if (idx > section.length) {
//                 break ;
//             }
//         }
//         return answer;
//     }
// }


class Solution {
    public static int solution(int n, int m, int[] section) {
        int maxValue = 0, answer = 0;
        for (int e : section) {
            if (maxValue <= e) {
                maxValue = e + m;
                answer++;
            }
        }
        return answer;
    }
}