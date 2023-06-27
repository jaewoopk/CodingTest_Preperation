package Programmers_lev2.June27;

public class jumpTeleport {
    public static void main(String[] args) {
        System.out.println(Solution627_1.solution(5));
        System.out.println(Solution627_1.solution(6));
        System.out.println(Solution627_1.solution(5000));
        System.out.println(Solution627_1.solution(244));
    }
}


class Solution627_1 {
    public static int recursive(int num, int count) {
        if (num == 1) {
            return count;
        }
        if (num % 2 == 0) return recursive(num / 2, count);
        else return recursive(num - 1, count + 1);
    }
    public static int solution(int n) {
        return recursive(n, 1);
    }
}


// public class Solution {
//     public static int solution(int n) {
//             return Integer.bitCount(n);
//     }
// }