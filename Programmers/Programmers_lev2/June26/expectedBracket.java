package Programmers_lev2.June26;

public class expectedBracket {
    public static void main(String[] args) {
        System.out.println(Solution626_1.solution(8, 4, 7));
    }
}

class Solution626_1 {
    public static int solution(int n, int a, int b) {
        int count = 0;
        while (a != b) {
            a = (int)((a + 1) / 2);
            b = (int)((b + 1) / 2);
            count++;
        }
        return count;
    }
}

// class Solution626_1 {
//     public static int solution(int n, int a, int b) {
//         int count = 1;
//         if (b > a) {
//             while (n >= 1) {
//                 if (Math.abs(a - b) == 1 && a % 2 == 1 && b % 2 == 0) {
//                     return count;
//                 }
//                 a = (int)((a + 1) / 2);
//                 b = (int)((b + 1) / 2);
//                 n /= 2;
//                 count++;
//             }
//         }
//         else {
//             while (n >= 1) {
//                 if (Math.abs(a - b) == 1 && a % 2 == 0 && b % 2 == 1) {
//                     return count;
//                 }
//                 a = (int)((a + 1) / 2);
//                 b = (int)((b + 1) / 2);
//                 n /= 2;
//                 count++;
//             }
//         }
//         return 1;
//     }
// }